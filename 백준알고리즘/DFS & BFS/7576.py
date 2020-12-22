# 7576 토마토
# BFS

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y, tomato):
    global count

    while q:
        count += 1
        for _ in range(len(q)):
            x, y = q.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < n and 0 <= ny < m:
                    if tomato[nx][ny] == 0:
                        tomato[nx][ny] = tomato[x][y] + 1
                        q.append([nx, ny])

    for t in tomato:
        if 0 in t:
            return -1
    return count


m, n = map(int, input().split())
tomato = []
visited = [[False] * m for _ in range(n)]
q = deque()
for i in range(n):
    array = list(map(int, input().split()))
    for j in range(m):
        if array[j] == 1:
            q.append([i, j])
    tomato.append(array)

count = -1

print(bfs(m, n, tomato))
