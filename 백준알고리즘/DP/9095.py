# 9095 1, 2, 3 더하기
# DP

# An = A(n-1) + A(n-2) + A(n-3)
t = int(input())
for _ in range(t):
    dp = [1, 2, 4]
    n = int(input())

    for i in range(3, n+1):
        dp.append(dp[i-1] + dp[i-2] + dp[i-3])
    print(dp[n-1])
