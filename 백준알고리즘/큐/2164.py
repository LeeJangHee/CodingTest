# 2164 카드2
import sys
from collections import deque

n = int(sys.stdin.readline().strip())

card = deque(i for i in range(1, n+1))

while True:
  if len(card) == 1:
    break;
  card.popleft()
  x = card.popleft()
  card.append(x)

print(card.pop())
