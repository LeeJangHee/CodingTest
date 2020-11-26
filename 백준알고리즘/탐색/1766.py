# 1766 문제집

import heapq

n, m = map(int, input().split())
array = [[] for i in range(n+1)]
indegree = [0]*(n+1)

heap = []
result = []

# 연결 확인
for _ in range(m):
    x, y = map(int, input().split())
    array[x].append(y)  # x --> y
    indegree[y] += 1    # 연결된 노드의 진입 차수

# 진입차수 == 0 인 모든 원소 힙에 삽입
for i in range(1, n+1):
    if indegree[i] == 0:
        heapq.heappush(heap, i)

# 큐가 빌때 까지 큐에 있는 데이터를 확인한다.
while heap:
    data = heapq.heappop(heap)
    result.append(data)
    for y in array[data]:
        indegree[y] -= 1
        if indegree[y] == 0:
            heapq.heappush(heap, y)

for i in result:
    print(i, end=' ')
