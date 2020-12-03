# 7562 나이트의 이동
# bfs

from collections import deque

dx = [2, 2, -2, -2, 1, -1, 1, -1]
dy = [1, -1, 1, -1, 2, 2, -2, -2]


def bfs(x, y, p1, p2):
    q = deque()
    q.append([x, y])
    chess[x][y] = 1
    while q:
        x, y = q.popleft()
        if x == p1 and y == p2:
            return chess[p1][p2] - 1
        for k in range(8):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < i and 0 <= ny < i:
                if chess[nx][ny] == 0:
                    q.append([nx, ny])
                    chess[nx][ny] = chess[x][y] + 1


n = int(input())
for _ in range(n):
    i = int(input())
    chess = [[0] * i for _ in range(i)]
    x, y = map(int, input().split())
    p1, p2 = map(int, input().split())
    print(bfs(x, y, p1, p2))
