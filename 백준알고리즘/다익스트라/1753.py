# 1753 최단경로
# 다익스트라
import heapq, sys
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())
array = [[] for i in range(n+1)]
# 최단 거리 테이블 초기화
distance = [INF] * (n+1)
# 초기화
for i in range(m):
    a, b, c = map(int, input().split())
    array[a].append((b, c))

def dijkstra(start):
    q = []
    # 시작노드로 경로 0 설정
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in array[now]:
            cost = dist + i[1]
            # 현재 노드를 거처서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 다익스트라 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
