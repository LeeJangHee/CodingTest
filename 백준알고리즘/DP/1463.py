# 1463 1로 만들기
# DP

n = int(input())
result = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
    if i == 1:
        result[i] = 0
        continue
    result[i] = result[i - 1] + 1
    if i % 3 == 0 and result[i // 3] + 1 < result[i]:
        result[i] = result[i // 3] + 1
    if i % 2 == 0 and result[i // 2] + 1 < result[i]:
        result[i] = result[i // 2] + 1

print(result[n])
