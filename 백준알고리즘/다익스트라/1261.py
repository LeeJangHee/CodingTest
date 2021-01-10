# 1261 알고스팟
# 최단경로

import heapq

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
m, n = map(int, input().split())

rooms = [[0] * m for _ in range(n)]
distance = [[-1] * m for _ in range(n)]

for i in range(n):
    x = input()
    for j in range(m):
        rooms[i][j] = int(x[j])


def dijkstra(a, b):
    q = []
    heapq.heappush(q, (0, a, b))

    while q:
        count, x, y = heapq.heappop(q)
        distance[x][y] = 1
        if x == n - 1 and y == m - 1:
            return count

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and distance[nx][ny] == -1:
                distance[nx][ny] = 1

                if rooms[nx][ny] == 0:
                    heapq.heappush(q, (count, nx, ny))
                elif rooms[nx][ny] == 1:
                    heapq.heappush(q, (count + 1, nx, ny))


print(dijkstra(0, 0))
