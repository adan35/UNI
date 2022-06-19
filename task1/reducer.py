#!/usr/bin/python3
"""reducer.py"""

import sys

prev_word = None
prev_count = 0

for line in sys.stdin:
  line = line.strip()
  word, count = line.split('\t')
  count = int(count)

  if prev_word == word:
    prev_count += count
  else:
    if prev_word:
      print('{}\t{}'.format(prev_word, prev_count))
    prev_word = word
    prev_count = count

if prev_word == word:
  print('{}\t{}'.format(prev_word, prev_count))