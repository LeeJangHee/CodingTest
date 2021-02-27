# 14938 서강그라운드
# 다익스트라 최단경로
import heapq


def dijkstra(start):
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


INF = int(1e9)
n, m, r = map(int, input().split())
items = list(map(int, input().split()))
arr = [[] for _ in range(n + 1)]

for _ in range(r):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
    arr[b].append((a, c))

result = []
for i in range(1, n + 1):
    distance = [INF] * (n + 1)
    dijkstra(i)

    max_item = 0
    for j in range(1, n + 1):
        if distance[j] <= m:
            max_item += items[j - 1]
    result.append(max_item)

print(max(result))
