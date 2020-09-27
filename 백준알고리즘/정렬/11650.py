# 좌표 정렬하기 11650

import sys

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    arr.append([a, b])

arr.sort()
for i in range(n):
    for j in range(len(arr[i])):
        print(arr[i][j], end=' ')
    print()
