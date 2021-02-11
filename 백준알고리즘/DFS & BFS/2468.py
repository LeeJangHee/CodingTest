# 2468 안전 영역
# 그래프 탐색

import sys
sys.setrecursionlimit(100000)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(h, x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < n) and (0 <= ny < n) and \
                arr[nx][ny] > h and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(h, nx, ny)


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
max_h = 0
for num in arr:
    max_h = max(num)

ans = -1
for h in range(1, max_h + 1):
    count = 0
    visited = [[False] * n for _ in range(n)]
    for x in range(n):
        for y in range(n):
            if arr[x][y] > h and not visited[x][y]:
                visited[x][y] = True
                dfs(h, x, y)
                count += 1
    ans = max(ans, count)

print(ans)
