#!/bin/bash

i=0

echo "========================================" $(date -u) >> he.txt

while true
do
        httpCode=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:9200/mdeforge.metamodels/_search)
	esCode=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:5601/app/home#/)
	
	echo "Checking if the server is live and running at $(date -u)" >> he.txt

	if [ $esCode == 200 ]; then
	
		# If the server is on, we exit
		if [ $httpCode == 200 ]; then
			echo "The index are intact, hence exiting!  $(date -u)" >> he.txt
			break
		
		# This means the server is down, we have to reload it
		else	
			# We wait for elasticsearch, and then we synchronize
			docker-compose up --build --force-recreate --no-deps -d monstache && echo $(date -u) 'run--- resynchronized the index' >> he.txt
			
			sleep 200
			
			# We query the server again, if the index exists - mdeforge.metamodels - then we exit
			hc=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:9200/mdeforge.metamodels/_search)
			
			# We check again to see if the server has been restarted, and then we will exit
			if [ $hc == 200 ]; then
				echo "==== Restarted the server successfully at $(date -u)" >> he.txt
				break
			fi
		fi
	else
                        echo "Elasticsearch seems to be down, attempting to restart it at $(date -u)" >> he.txt
                        docker-compose restart elasticsearch && echo $(date -u) 'run--- elasticsearch restarted' >> he.txt

                        # We wait for elasticsearch, and then we synchronize
                        sleep 200
                        docker-compose up --build --force-recreate --no-deps -d monstache && echo $(date -u) 'run--- resynchronized the index' >> he.txt

                        # We query the server again, if the index exists - mdeforge.metamodels - then we exit
                        hc=$(curl -s -o /dev/null -w "%{http_code}" http://178.238.238.209:9200/mdeforge.metamodels/_search)
			
			sleep 200

                        # We will check again to see if the server has been restarted, and then we will exit
                        if [ $hc == 200 ]; then
                                echo "==== Restarted the server successfully at $(date -u)" >> he.txt
                                break
                        fi
	
	fi
	
	# We run the script 5 times, otherwise we wait for next cronjob and send myself an email 
	if [ $i == 4 ]; then
		echo "Wait for next time... cron job running after 15 MINS" >> he.txt
		echo "The server failed to start, please login and fix it" | mailx -r "Server notification" -s "SERVER CRUSHED, PLEASE FIX!!!!" arsene@indamutsa.net,indamutsa@mail.com
		break
	fi

	((i++))
done

