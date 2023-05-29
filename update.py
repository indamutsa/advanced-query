import pymongo

myclient = pymongo.MongoClient("mongodb://34.67.33.7:27019")
mydb = myclient["mdeforge"]
mycol = mydb["metamodels"]

myquery = { "type": "MODEL" }
newvalues = { "$set": { "type": "METAMODEL" } }

x = mycol.update_many(myquery, newvalues)

print(x.modified_count, "documents updated.")
