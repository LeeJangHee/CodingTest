# 2667 단지번호붙이기
# https://www.acmicpc.net/problem/2667

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# input
n = int(input())
city = [list(map(int, list(input()))) for _ in range(n)]


def bfs(x, y):
    count = 1
    city[x][y] = 0
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < n:
                if city[nx][ny] == 1:
                    count += 1
                    city[nx][ny] = 0
                    q.append((nx, ny))
    return count


black = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            black.append(bfs(i, j))

# output
print(len(black))
for i in sorted(black):
    print(i)
