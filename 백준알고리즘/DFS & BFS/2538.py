# 2583 영역 구하기

import sys
from collections import deque

m, n, k = map(int, sys.stdin.readline().split())
arr = [[0] * n for _ in range(m)]

# 좌 우 상 하
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 그룹 수, 맴버 수
arr_member = []


def bfs(x, y):
    q = deque()
    q.append([x, y])
    arr[x][y] = 1
    num = 1

    while q:
        a, b = q.popleft()

        for dir in range(4):
            nx = a + dx[dir]
            ny = b + dy[dir]

            if 0 <= nx < m and 0 <= ny < n:
                if arr[nx][ny] == 0:
                    arr[nx][ny] = 1
                    num += 1
                    q.append([nx, ny])

    arr_member.append(num)


# input
for i in range(k):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())

    # 사각형 visit
    for x in range(x1, x2):
        for y in range(y1, y2):
            arr[y][x] = 1

# dfs
for x in range(m):
    for y in range(n):
        if arr[x][y] == 0:
            bfs(x, y)


arr_member.sort()
print(len(arr_member), end='\n')
for i in arr_member:
    print(i, end=' ')
