!/bin/bash

i=0

while true
do
        # httpCode=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:9200/mdeforge.metamodels/_search)
		httpCode=$(curl -s -o /dev/null -w "%{http_code}"  https://178.238.238.209.sslip.io/repo/elastic/mdeforge.metamodels/_search)
	
	# If the server is on, we exit
	if [ $httpCode == 200 ]; then
		echo "Elasticsearch is running, exiting the loop no need to restart!  $(date -u)" >> he.txt
		echo "The server failed to start, please login and fix it" | mailx -r "Server notification" -s "Elasticsearch notification" arsene@indamutsa.net,indamutsa@mail.com
		break
	# This means the server is down, we have to reload it
	else
                echo "Elasticsearch seems it is down, attempting to restart at $(date -u)" >> he.txt
                docker-compose restart elasticsearch && echo $(date -u) 'run--- elasticsearch restarted' >> he.txt
                
		# We wait for elasticsearch, and then we synchronize
		sleep 200
		docker-compose restart monstache && echo $(date -u) 'run--- resynchronized the index' >> he.txt
		
		# We query the server again, if the index exists - mdeforge.metamodels - then we exit
		# hc=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:9200/mdeforge.metamodels/_search)
		hc=$(curl -s -o /dev/null -w "%{http_code}"  https://178.238.238.209.sslip.io/repo/elastic/mdeforge.metamodels/_search)
		
		# We will check again to see if the server has been restarted, and then we will exit
		if [ $hc == 200 ]; then
			echo "==== Restarted the server successfully at $(date -u)" >> he.txt
			break
		fi
        fi

	# We run the script 5 times, otherwise we wait for next cronjob and send myself an email 
	if [ $i == 4 ]; then
		echo "Wait for next time... cron job running after 1 hour" >> he.txt
		echo "The server failed to start, please login and fix it" | mailx -r "Server notification" -s "Elasticsearch notification" arsene@indamutsa.net,indamutsa@mail.com
		break
	fi

	((i++))
done


