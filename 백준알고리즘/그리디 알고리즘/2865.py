# 2865 나는 위대한 슈퍼스타K

import sys

n, m, k = map(int, sys.stdin.readline().split())

mScore = {}
for i in range(n):
    mScore[i + 1] = 0

for i in range(m):
    people = list(map(float, sys.stdin.readline().split()))
    for j in range(0, n * 2, 2):
        if people[j + 1] > mScore[people[j]]:
            mScore[people[j]] = people[j + 1]

score = sorted(list(mScore.values()), reverse=True)
sumScore = sum(score[:k])
print('%.1f' % sumScore)  # 소수 첫째 자리
