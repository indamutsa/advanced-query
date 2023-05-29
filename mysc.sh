echo "The server failed to start, please login and fix it" >> he.txt
echo "The server failed to start, please login and fix it" | mailx -r "Server notification" -s "Elasticsearch notification" arsene@indamutsa.net,indamutsa@mail.com
