# 1748 수 이어 쓰기 1

import sys

input = sys.stdin.readline

n = int(input())
ans, i = 0, 1
while i <= n:
    ans += (n-i+1)
    i *= 10
print(ans)
