# 1012 유기농 배추

import sys
sys.setrecursionlimit(10**6) # 제귀함수 깊이 설정
input = sys.stdin.readline

def dfs(x, y):
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False
    if arr[x][y] == 1:
        # 해당 노드 방문처리
        arr[x][y] = 0
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    # 밭 배열
    arr = [[0] * n for _ in range(m)]

    # 배추 위치
    for i in range(k):
        x, y = map(int, input().split())
        arr[x][y] = 1

    # dfs 수행
    result = 0
    for i in range(m):
        for j in range(n):
            if dfs(i, j) == True:
                result += 1

    # 정답 출력
    print(result)
