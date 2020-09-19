# 18258 큐2

import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque([])
for i in range(n):
  x = sys.stdin.readline().split()

  if x[0] == 'push':
    queue.append(x[1])
  elif x[0] == 'pop':
    if not queue:
      print(-1)
    else:
      print(queue.popleft())
  elif x[0] == 'size':
    print(len(queue))
  elif x[0] == 'empty':
    if not queue:
      print(1)
    else:
      print(0)
  elif x[0] == 'front':
    if not queue:
      print(-1)
    else:
      print(queue[0])
  elif x[0] == 'back':
    if not queue:
      print(-1)
    else:
      print(queue[-1])
