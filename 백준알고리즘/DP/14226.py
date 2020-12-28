# 14226 이모티콘
# DFS/BFS
# 다시 풀어보기
from collections import deque

s = int(input())
check = [[-1] * (s + 1) for _ in range(s + 1)]


def bfs():
    q = deque()
    q.append([1, 0])
    check[1][0] = 0
    while q:
        x, y = q.popleft()

        # 1. 복사
        if check[x][x] == -1:
            check[x][x] = check[x][y] + 1
            q.append([x, x])
        # 2. 붙여넣기
        if x + y <= s and check[x + y][y] == -1:
            check[x + y][y] = check[x][y] + 1
            q.append([x + y, y])
        # 3. 삭제
        if x - 1 >= 0 and check[x - 1][y] == -1:
            check[x - 1][y] = check[x][y] + 1
            q.append([x - 1, y])


bfs()

sec = check[s][1]
for i in range(1, s):
    if check[s][i] != -1:
        sec = min(sec, check[s][i])
print(sec)
