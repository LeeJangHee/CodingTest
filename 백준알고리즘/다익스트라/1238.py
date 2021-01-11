# 1238 파티
# 다익스트라

import heapq

INF = int(1e9)
n, m, t = map(int, input().split())

array = [[] for _ in range(n + 1)]
for i in range(m):
    a, b, c = map(int, input().split())
    array[a].append((b, c))


def dijkstra(start):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        w, x = heapq.heappop(q)

        for nx, nw in array[x]:
            nw += w
            if nw < distance[nx]:
                distance[nx] = nw
                heapq.heappush(q, (nw, nx))
    return distance


answer = [0] * (n + 1)
for i in range(1, n + 1):
    dist = dijkstra(i)
    answer[i] += dist[t]
    dist = dijkstra(t)
    answer[i] += dist[i]
print(max(answer))
