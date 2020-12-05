# 1743 음식물 피하기
# bfs
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    count = 1
    q = deque()
    q.append((x, y))
    visit[x][y] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 < nx < n + 1 and 0 < ny < m + 1:
                if not visit[nx][ny] and array[nx][ny] == 1:
                    q.append((nx, ny))
                    visit[nx][ny] = True
                    count += 1
    return count


n, m, k = map(int, input().split())
array = [[0] * (m + 1) for _ in range(n + 1)]
visit = [[False] * (m + 1) for _ in range(n + 1)]
for i in range(k):
    x, y = map(int, input().split())
    array[x][y] = 1

result = []
for i in range(1, n+1):
    for j in range(1, m+1):
        if array[i][j] == 1:
            result.append(bfs(i, j))

print(max(result))
