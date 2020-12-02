# 4963 섬의 개수
# dfs 풀이
import sys
sys.setrecursionlimit(10**5)

def dfs(x, y):
    # 범위 벗어나면 즉시 종료
    if x < 0 or x >= m or y < 0 or y >= n:
        return False
    # 현재 노드 방문 x
    if not visit[x][y] and array[x][y] == 1:
        visit[x][y] = True
        # 가로, 세로, 대각선
        dfs(x-1, y-1)
        dfs(x-1, y)
        dfs(x-1, y+1)
        dfs(x, y-1)
        dfs(x, y+1)
        dfs(x+1, y-1)
        dfs(x+1, y)
        dfs(x+1, y+1)
        return True
    return False

while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    # map array
    array = [list(map(int, input().split())) for _ in range(m)]
    visit = [[False] * n for _ in range(m)]
    count = 0
    for i in range(m):
        for j in range(n):
            if array[i][j] == 1:
                if dfs(i, j):
                    count += 1

    print(count)
