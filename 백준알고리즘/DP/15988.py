# 15988 1, 2, 3 더하기3
# DP

# An = A(n-1) + A(n-2) + A(n-3)
dp = [1, 2, 4]
for i in range(3, 1000001):
    dp.append((dp[i-1]+dp[i-2]+dp[i-3]) % 1000000009)
t = int(input())
for _ in range(t):
    n = int(input())
    print(dp[n-1])
