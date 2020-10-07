# 2847 게임을 만든 동준이

import sys

input = sys.stdin.readline

n = int(input())
score = []
for _ in range(n):
    score.append(int(input()))

score.reverse()
count = 0
for i in range(1, n):
    if score[i] > score[i - 1]:
        count += score[i] - score[i - 1] + 1
        score[i] = score[i - 1] - 1
print(count)
