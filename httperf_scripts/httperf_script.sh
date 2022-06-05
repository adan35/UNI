httperf --hog  --timeout=60 --server=172.17.0.6 --port=80 --wsesslog=10000000,0,urls.txt --rate $1 -v&
sleep 30
skill -2 httperf
