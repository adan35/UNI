#!usr/bin/python3
"""reducer.py"""

if __name__== '__main__':

  try:

    import sys

    neg_tweets, pos_tweets, neu_tweets = [], [], []

    for line in sys.stdin:
      if len(line) <= 1:
        continue
      line = line.strip()
      line = line.split('\t\t\t')
      key, tweet = line[0], line[1]
      key = float(key)
      if key < 0:
        neg_tweets.append(tweet)
        with open('negative_tweets.json', 'a') as negf_tweets:
          negf_tweets.write("{}\n".format(tweet))
      elif key > 0:
        pos_tweets.append(tweet)
        with open('positive_tweets.json', 'a') as posf_tweets:
          posf_tweets.write("{}\n".format(tweet))
      else:
        neu_tweets.append(tweet)
        with open('neutral_tweets.json', 'a') as neuf_tweets:
          neuf_tweets.write("{}\n".format(tweet))
      
      print('{}\t\t\t{}'.format(key, tweet))
    
  except:
    print("An exception occurred")

