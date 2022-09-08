#!usr/bin/python3
"""mapper.py"""

def formula(p,n):
  return (p-1)/(p+n+2)

if __name__== '__main__':

  try:

    import sys
    import json
    from collections import Counter

    # opening negative and positive word files
    with open("negative_words.txt") as neg_file, open("positive_words.txt") as pos_file:

      neg_c = Counter(neg_file.read().strip().split())
      pos_c = Counter(pos_file.read().strip().split())

      for line in sys.stdin:
        # counts the number of times a word appears in a tweet
        neg_count = pos_count = 0
        # parse json
        data = json.loads(line)
        # str to list
        words = data["social_feed"]
        if words is None:
          continue
        words = words.strip().split()
        # iterate through words
        for word in words:
          # search for word in negative and positive counter
          if neg_c[word]:
            neg_count += 1
          elif pos_c[word]:
            pos_count += 1
        # output
        print('{}\t\t\t{}'.format(formula(pos_count,neg_count), line))

  except:
    print("An exception occurred")

