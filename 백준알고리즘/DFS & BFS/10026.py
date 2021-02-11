# 10026 적록색약

import sys
sys.setrecursionlimit(100000)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


# 색약
def color_dfs(x, y):
    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            if arr[x][y] == 'R' or arr[x][y] == 'G':
                if arr[nx][ny] != 'B':
                    color_dfs(nx, ny)
            else:
                if arr[nx][ny] == 'B':
                    color_dfs(nx, ny)


# 색약x
def normal_dfs(x, y):
    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            if arr[x][y] == arr[nx][ny]:
                normal_dfs(nx, ny)


n = int(input())

arr = [[''] * n for _ in range(n)]
for i in range(n):
    x = input()
    for j in range(len(x)):
        arr[i][j] = x[j]

color = 0
normal = 0

visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            color_dfs(i, j)
            color += 1

visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            normal_dfs(i, j)
            normal += 1

print(normal, end=' ')
print(color)
