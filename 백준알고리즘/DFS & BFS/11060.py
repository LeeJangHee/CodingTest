# 11060 점프점프
# DP / BFS
from collections import deque
n = int(input())
array = list(map(int, input().split()))

dp = [-1] * n

def bfs(start):
    q = deque()
    q.append(start)
    dp[start] = 0
    while q:
        now = q.popleft()
        jump = array[now]
        for i in range(jump, 0, -1):
            if now + i < n and dp[now + i] == -1:
                dp[now + i] = dp[now] + 1
                q.append(now + i)

bfs(0)
print(dp[-1])
