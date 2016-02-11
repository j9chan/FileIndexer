import re
from collections import Counter

with open('t1.in') as f:
        passage = f.read()

        words = re.findall(r'w+', passage)

        cap_words = [word.upper() for word in words]

        word_counts = Counter(cap_words)

        word_counts
