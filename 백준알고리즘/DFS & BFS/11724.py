# 11724 연결 요소의 개수
# dfs
import sys

sys.setrecursionlimit(10000)

n, m = map(int, input().split())
array = [[0] * (n + 1) for _ in range(n + 1)]
visit = [False] * (n + 1)
count = 0


def dfs(i):
    visit[i] = True
    for k in range(1, n + 1):
        if array[i][k] == 1 and not visit[k]:
            dfs(k)


for _ in range(m):
    x, y = map(int, input().split())
    array[x][y] = 1
    array[y][x] = 1

for i in range(1, n + 1):
    if not visit[i]:
        dfs(i)
        count += 1
print(count)
