# 1504 특정한 최단 경로
# 다익스트라

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)


def dijkstra(start):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in arr[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance


n, e = map(int, input().split())
arr = [[] for _ in range(n + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
    arr[b].append((a, c))

v1, v2 = map(int, input().split())

one = dijkstra(1)
_v1 = dijkstra(v1)
_v2 = dijkstra(v2)
count = min(one[v1] + _v1[v2] + _v2[n],
            one[v2] + _v2[v1] + _v1[n])
print(count if count < INF else -1)
