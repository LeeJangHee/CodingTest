# 11403 경로 찾기
# dfs
import sys

sys.setrecursionlimit(100000)


def dfs(x):
    for i in range(n):
        if visit[i] == 0 and array[x][i] == 1:
            visit[i] = 1
            dfs(i)


n = int(input())
array = []
visit = [0 for _ in range(n)]
for i in range(n):
    array.append(list(map(int, input().split())))

for i in range(n):
    dfs(i)
    for j in range(n):
        if visit[j] == 1:
            print(1, end=' ')
        else:
            print(0, end=' ')
    print()
    visit = [0 for i in range(n)]
