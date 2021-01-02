# 15591 MooTube(Silver)
# BFS

from collections import deque

n, q = map(int, input().split())
INF = int(1e9)


def bfs(k, v):
    count = 0
    q = deque()
    q.append((v, INF))
    # 최단거리 테이블 초기화
    visit = [False] * (n + 1)
    visit[v] = True

    while q:
        node, mDist = q.popleft()
        for nextNode, dist in array[node]:
            if visit[nextNode]:
                continue

            if mDist > dist:
                q.append((nextNode, dist))
                if dist >= k:
                    count += 1
            else:
                q.append((nextNode, mDist))
                if mDist >= k:
                    count += 1
            visit[nextNode] = True

    return count


# 그래프 초기화
array = [[] for _ in range(n + 1)]

# 간선 설정
for i in range(n - 1):
    a, b, c = map(int, input().split())
    array[a].append((b, c))
    array[b].append((a, c))

# 질문
for i in range(q):
    k, v = map(int, input().split())
    print(bfs(k, v))
