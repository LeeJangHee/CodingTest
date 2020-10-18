# 2178 미로 탐색

from collections import deque

#    우  좌  하  상
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

n, m = map(int, input().split())
a = [list(map(int, list(input()))) for _ in range(n)]

q = deque()
visit = [[False] * m for _ in range(n)]
dist = [[0] * m for _ in range(n)]

# bfs start
q.append((0, 0))
visit[0][0] = True
dist[0][0] = 1

while q:
    x, y = q.popleft()
    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < m:
            if not visit[nx][ny] and a[nx][ny] == 1:
                q.append((nx, ny))
                dist[nx][ny] = dist[x][y] + 1
                visit[nx][ny] = True

print(dist[n - 1][m - 1])
