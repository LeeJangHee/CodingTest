# 1325 효율적인 해킹

from collections import deque

n, m = map(int, input().split())
computer = [[] for _ in range(n+1)]

for i in range(m):
    x, y = map(int, input().split())
    computer[y].append(x)


def bfs(start):
    q = deque([start])
    visited = [False] * (n+1)
    visited[start] = True
    count = 1
    while q:
        x = q.popleft()
        for e in computer[x]:
            if not visited[e]:
                q.append(e)
                visited[e] = True
                count += 1
    return count

result = []
max_value = -1

for i in range(1, n+1):
    c = bfs(i)
    if c > max_value:
        result = [i]
        max_value = c
    elif c == max_value:
        result.append(i)
        max_value = c

for e in result:
    print(e, end=' ')
