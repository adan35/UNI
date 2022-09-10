import requests
import time
from os.path import exists
import os
# import threading as mp
import multiprocessing as mp

def req1(start, end):
  url = "http://127.0.0.1:6000/api/gen"
  start1 = start
  end1 = end//3
  requests.post(url, json={"start": start1, "end": end1})

def req2(start, end):
  url = "http://127.0.0.1:7000/api/gen"
  start1 = end//3
  end1 = start1 + start1
  requests.post(url, json={"start": start1, "end": end1})

def req3(start, end):
  url = "http://127.0.0.1:8000/api/gen"
  start1 = end//3 + end//3
  end1 = start1 + start1
  requests.post(url, json={"start": start1, "end": end1})

def monitor_csv():
  file = './monitor.csv'
  
  url1 = "http://127.0.0.1:6000/api"
  
  if exists(file):
    os.remove(file)

  with open(file, 'a') as f:
    f.write('time stamp       ,cpu, memory\n')
    while True:
      time.sleep(62)
      res1 = requests.post(url1 + '/mon', json={"k": 1}).json()

      res1 = res1["consumptions"][-1]

      s1 = res1["time_stamp"] + ',' + res1["cpu"] + ',' + res1["memory"] + '\n'

      if res1["time_stamp"] == "":
        break

      f.write(s1)

def get_prime_file1():
  url1 = "http://127.0.0.1:6000/api/get"
  while True:
    time.sleep(122)
    res = requests.get(url1).json()["prime_nums"]
    open('./prime1.txt', 'w').write(str(res))
  return res

def get_prime_file2():
  url1 = "http://127.0.0.1:7000/api/get"
  while True:
    time.sleep(122)
    res = requests.get(url1).json()["prime_nums"]
    open('./prime2.txt', 'w').write(str(res))
  return res

def get_prime_file3():
  url1 = "http://127.0.0.1:8000/api/get"
  while True:
    time.sleep(122)
    res = requests.get(url1).json()["prime_nums"]
    open('./prime3.txt', 'w').write(str(res))
  return res

def make_threads(start, end):
  p1 = mp.Process(target=(req1), args=(start, end,))
  p2 = mp.Process(target=(req2), args=(start, end,))
  p3 = mp.Process(target=(req3), args=(start, end,))
  p4 = mp.Process(target=(monitor_csv))
  p5 = mp.Process(target=(get_prime_file1))
  p6 = mp.Process(target=(get_prime_file2))
  p7 = mp.Process(target=(get_prime_file3))

  p1.start()
  p2.start()
  p3.start()
  p4.start()
  p5.start()
  p6.start()
  p7.start()

  p1.join()
  p2.join()
  p3.join()
  p4.join()
  p5.join()
  p6.join()
  p7.join()


make_threads(-1, 10**5)