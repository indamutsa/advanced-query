import requests
import os
import sys
import pdb


paths = ['/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/ecore_memorec/', '/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/ZooATLAndMar/', '/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/instances_xmi_ecore/', '/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/dataUML_good_ALL/']

# path = paths[int(sys.argv[2])]
# path = '/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/ZooATLAndMar/'
# path = '/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/ecore_memorec/'
# path = "/home/arsene/Project/school-projects/mdeforge/data/models-metamodels/instances_xmi_ecore/"
# url = "http://localhost:3200/store/" #"http://34.67.33.7:3200/store/" 
urls = ["http://localhost:3200/store/", "http://178.238.238.209:3200/store/","http://34.67.33.7:3200/store/"]
url = urls[int( sys.argv[1])]

##############################################################################

query = { "username": "arsene"}
response = requests.get(url + "user", params=query)
d = response.json()
# print(d['user']['username'])


# Querying workspace
query_w = { "username": d['user']['username']}
response = requests.get( url +  "workspace", params=query_w)
workspace_d = response.json()
# print(workspace_d['workspaces'][0]['projects'][0])


# Querying project
project_id = workspace_d['workspaces'][0]['projects'][0]
query_w = { "id": project_id }
response = requests.get(url + "project", params=query_w)
project_d = response.json()
# print(project_d)


# -----------------------------------------------------------------------------
# Testing post method with user
# w_user = { "username": "almonte", "email":"almonte@indamutsa.com" }
# res = requests.post( url + "user", json=w_user)
# print(res.json())

def iloveLissette(filename, path):
    ## Uploading the metamodel
    uri = url + "artifact/model"
    # uri = url + "artifact/metamodel"

    # payload={'description': 'We are trying to save the model using the api','metamodel': '624aa0c208cea6001374ad66', 'project': project_id}
    payload={'description': 'We are trying to save the metamodel using the api','project': project_id}

    files=[('file',(filename,open(path + filename,'rb'),'application/octet-stream'))]
    headers = {}

    response = requests.request("POST", uri, headers=headers, data=payload, files=files)

    #print(response.status_code)
    return response


##############################################################################
# pdb.set_trace()
# iterate through all file
i = 0
failed_entry = []
already_entry = []
already_exist = 0
total_execution = 0
total_success = 0
total_fail = 0


for path in paths:
    # Change the directory
    os.chdir(path)
    i = 0
    for f in os.listdir():
        #  print(f)
        # Check whether file is in text format or not
        if f.endswith(sys.argv[2]):
            total_execution = total_execution + 1
            # file_path = f"{path}/{f}"
            data = iloveLissette(f, path)
            
            # print(data.status_code)
            if data.status_code != 200 and data.status_code != 409:
                failed_entry.append(f)
                total_fail = total_fail + 1
            elif data.status_code == 409:
                already_exist = already_exist + 1
                already_entry.append(f)
            else:
                total_success = total_success + 1
        
            print("Execution...:", total_execution)
        
        # i = i + 1
        # if i == 1:
        #     break
            
        # call read text file function
        # read_text_file(file_path)

    print("Total execution: ", total_execution)
    print("Total success: ", total_success)
    print("Total fail: ", total_fail)
    print("already exists entry: ", already_exist)

    print("Failed entry: ")

    if len(failed_entry) == 0:
        print("Total success, nothing failed!")
    else:    
        for e in failed_entry:
            print("- ", e)

    print("Already existing entries: ")
    if len(already_entry) == 0:
        print("No duplicates")
    else:
        for n in already_entry:
            print("- ", n)

    print("==================================--=======================================")
    
##############################################################################



# The match_phrase_prefix query is similar to the match_phrase query, but here the last term of the search keyword 
# is considered as a prefix and is used to match any term starting with that prefix term.
# First, let’s insert a document into our index to better understand the match_phrase_prefix query: