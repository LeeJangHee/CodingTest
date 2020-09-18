# 1158 요세푸스 문제

import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
queue = deque(i for i in range(1, n+1))
answer = list()
for i in range(n):
  # 큐 크기가 k 보다 작을 경우
  if len(queue) < k:
    answer.append(str(queue.popleft()))
  # 큐 크가가 k 보다 클 경우
  else:
    # k-1번 만큼 큐에있는 값을 뒤로 보낸다.
    for j in range(k-1):
      x = queue.popleft()
      queue.append(x)
    answer.append(str(queue.popleft()))
  
print("<%s>" % ", ".join(answer))
