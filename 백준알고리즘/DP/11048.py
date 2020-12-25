# 11048 이동하기
# DP

n, m = map(int, input().split())

dp = [[0] * (m+1) for _ in range(n+1)]
a = []

for i in range(n):
    a.append(list(map(int, input().split())))

for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = a[i-1][j-1] + max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])

print(dp[n][m])
