# 1783 병든 나이트

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
answer = 1

if n == 1:
    answer = 1
elif n == 2:
    answer = min(4, (m + 1) // 2)
else:
    if m < 7:
        answer = min(4, m)
    else:
        answer = m - 2

print(answer)
