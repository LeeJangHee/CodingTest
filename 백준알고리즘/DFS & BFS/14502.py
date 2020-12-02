# 14502 연구소
# 조합 + bfs

from collections import deque
import copy

n, m = map(int, input().split())
array = [[0] * m for _ in range(n)]
q = deque()
ans = 0

for i in range(n):
    x = input()
    for j in range(m):
        array[i][j] = int(x.split(' ')[j])


# 벽 세우기
def safeWall(x):
    if x == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if array[i][j] == 0:
                array[i][j] = 1
                safeWall(x + 1)
                array[i][j] = 0


# bfs
def bfs():
    global ans
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    w = copy.deepcopy(array)
    for i in range(n):
        for j in range(m):
            if w[i][j] == 2:
                q.append([i, j])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if w[nx][ny] == 0:
                    w[nx][ny] = 2
                    q.append([nx, ny])

    cnt = 0
    for i in w:
        cnt += i.count(0)
    ans = max(ans, cnt)


safeWall(0)
print(ans)
