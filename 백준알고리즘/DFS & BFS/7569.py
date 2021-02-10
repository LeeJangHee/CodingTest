# 7569 토마토
# 그래프 탐색
from collections import deque

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


def bfs():
    while q:
        x, y, z = q.popleft()
        visited[x][y][z] = True

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m:
                if not visited[nx][ny][nz] and tomato[nx][ny][nz] == 0:
                    visited[nx][ny][nz] = True
                    tomato[nx][ny][nz] = tomato[x][y][z] + 1
                    q.append([nx, ny, nz])


m, n, h = map(int, input().split())
tomato = [list(list(map(int, input().split())) for _ in range(n)) for _ in range(h)]
visited = [[[False] * m for _ in range(n)] for _ in range(h)]
q = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k] == 1:
                q.append([i, j, k])

bfs()
max_day = 0
no_make = False
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k] == 0:
                no_make = True
            max_day = max(max_day, tomato[i][j][k])

if no_make:
    print(-1)
else:
    print(max_day - 1)
