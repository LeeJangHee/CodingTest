# 2644 촌수계산
# bfs
from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())
family = [[] for _ in range(n+1)]
visited = [False] * (n + 1)

for i in range(m):
    x, y = map(int, input().split())
    family[x].append(y)
    family[y].append(x)


def bfs(v, target):
    count = 0
    q = deque([[v, count]])
    while q:
        value = q.popleft()
        v = value[0]
        count = value[1]
        if v == target:
            return count

        if not visited[v]:
            count += 1
            visited[v] = True
            for e in family[v]:
                if not visited[e]:
                    q.append([e, count])
    return -1

print(bfs(a, b))
