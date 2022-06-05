#!/bin/bash

for (( i=10; i<=100; i+=1 ))
do
	./httperf_script.sh $i 
done


