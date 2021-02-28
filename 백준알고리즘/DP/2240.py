# 2240 자두나무
# DP

t, w = map(int, input().split())
arr = [0]
for _ in range(t):
    arr.append(int(input()))

dp = [[0] * (w + 1) for _ in range(t + 1)]

for i in range(1, t + 1):
    # 움직이지 않을 경우
    if arr[i] == 1:
        dp[i][0] = dp[i - 1][0] + 1
    else:
        dp[i][0] = dp[i - 1][0]

    # 이동한 경우
    for j in range(1, w + 1):
        if j > i:
            break

        # 자두 = 1, 받아먹기
        if arr[i] == 1 and j % 2 == 0:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + 1
        # 자두 = 2, 받아먹기
        elif arr[i] == 2 and j % 2 == 1:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + 1
        # 그외 안먹는다 -> 그대로 있거나 움직여서 안먹음
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1])

print(max(dp[-1]))
