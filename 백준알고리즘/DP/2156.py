# 2156 포도주 시식
# DP

n = int(input())
array = [0]
for i in range(n):
    array.append(int(input()))

dp = [0, array[1]]
if n > 1:
    dp.append(array[1] + array[2])
# 연속으로 3잔을 마시지 않아야함
# 1. 지금 포도주를 먹고 이전 포도주를 먹지 않은 경우
# 2. 지금 포도주를 먹고 이전 포도주를 먹은 경우
# 3. 지금 포도주를 먹지 않아야하는 경우
# 세가지 경우를 고려하여 MAX

for i in range(3, n + 1):
    maxCount = max(dp[i - 1], dp[i - 2] + array[i], dp[i - 3] + array[i - 1] + array[i])
    dp.append(maxCount)

print(dp[n])
