# 5014 스타트링크
# bfs

from collections import deque


def bfs(start):
    q = deque()
    q.append(start)
    array[start] = 1
    while q:
        x = q.popleft()
        if x == g - 1:
            print(array[x] - 1)
            return
        for i in range(2):
            nx = x + dx[i]
            if 0 <= nx < f and array[nx] == 0:
                q.append(nx)
                array[nx] = array[x] + 1

    return print("use the stairs")


f, s, g, u, d = map(int, input().split())

array = [0] * f
dx = [u, -d]
bfs(s - 1)
