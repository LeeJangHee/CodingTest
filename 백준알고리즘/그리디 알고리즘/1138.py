# 1138 한 줄로 서기

import sys

input = sys.stdin.readline

n = int(input().strip())
line = list(map(int, input().split()))
arr = [0]*n

for i in range(n):
    x = line[i]
    count = 0
    for j in range(n):
        if count == x and arr[j] == 0:
            arr[j] = i + 1
            break
        elif arr[j] == 0:
            count += 1

print(*arr)
