# 16112 5차 전직

import sys
n, k = map(int, sys.stdin.readline().split())
exp = list(map(int, sys.stdin.readline().split()))
exp_sum = 0

exp.sort()
a = 0
for i in range(n):
    exp_sum += exp[i] * a
    if(a < k):
        a += 1

print(exp_sum)
