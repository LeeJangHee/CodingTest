# 13549 숨바꼭질3
# DFS/BFS

from collections import deque

n, k = map(int, input().split())
MAX = 10 ** 5 + 1
array = [-1] * MAX
q = deque([n])
array[n] = 0

while q:
    x = q.popleft()
    for nx in [2 * x, x + 1, x - 1]:
        if 0 <= nx < MAX and array[nx] == -1:
            if nx == 2 * x:
                # 시간이 필요 없는 2n 우선순위
                q.appendleft(nx)
                array[nx] = array[x]
            else:
                q.append(nx)
                array[nx] = array[x] + 1

print(array[k])
