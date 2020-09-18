# 3986 좋은 단어

import sys

n = int(sys.stdin.readline().strip())
count = 0

for i in range(n):
  st = sys.stdin.readline().strip()
  stack = []

  for index in range(len(st)):
    if not stack:
      stack.append(st[index])
    else:
      top = stack[-1]
      if top == st[index]:
        stack.pop()
      else:
        stack.append(st[index])
        continue

  if not stack:
    count += 1

print(count)
