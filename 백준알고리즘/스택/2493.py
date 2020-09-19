# 2493 탑

import sys

n = int(sys.stdin.readline().strip())
lay = [0 for _ in range(n)]
tower = list(map(int, sys.stdin.readline().split()))
stack = []

for i in range(len(tower)-1, -1, -1):
    while stack and tower[stack[-1]] < tower[i]:
        lay[stack.pop()] = i+1
    stack.append(i)

print(*lay)
