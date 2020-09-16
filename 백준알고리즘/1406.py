# 1406 에디터 시간초과
import sys
from collections import deque

stack1 = deque(sys.stdin.readline().strip())
stack2 = deque()
n = int(sys.stdin.readline().strip())

for _ in range(n):
  line = sys.stdin.readline().rstrip()
  if line[0] == 'L':
    if stack1:
      stack2.append(stack1.pop())
  elif line[0] == 'D':
    if stack2:
      stack1.append(stack2.pop())
  elif line[0] == 'B':
    if stack1:
      stack1.pop()
  elif line[0] == 'P':
    stack1.append(line[2])
    
stack1.extend(reversed(stack2))
print(''.join(stack1))
