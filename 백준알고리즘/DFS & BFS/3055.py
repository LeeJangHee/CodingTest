# 3055 탈출
# DFS/BFS

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n, m = map(int, input().split())

array = [[] * m for _ in range(n)]
visit = [[0] * m for _ in range(n)]

for i in range(n):
    ch = list(input())
    for j in range(m):
        array[i].append(ch[j])

dq = deque()
d1, d2 = 0, 0
for i in range(n):
    for j in range(m):
        if array[i][j] == '*':
            dq.append([i, j])
        if array[i][j] == 'S':
            dq.appendleft([i, j])
        elif array[i][j] == 'D':
            d1, d2 = i, j


def bfs():
    flag = False

    while dq:
        if flag:
            return
        x, y = dq.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            # 지도 범위 안
            if 0 <= nx < n and 0 <= ny < m:
                # 물이 다음 이동 지역
                if array[x][y] == '*':
                    if array[nx][ny] == '.' or array[nx][ny] == 'S':
                        array[nx][ny] = '*'
                        dq.append([nx, ny])

                # 이동 가능 지역
                elif array[x][y] == 'S':
                    if array[nx][ny] == '.':
                        array[nx][ny] = 'S'
                        visit[nx][ny] = visit[x][y] + 1
                        dq.append([nx, ny])
                    # 도착
                    elif array[nx][ny] == 'D':
                        flag = True
                        visit[nx][ny] = visit[x][y] + 1
                        break


bfs()
if visit[d1][d2] == 0:
    print('KAKTUS')
else:
    print(visit[d1][d2])
