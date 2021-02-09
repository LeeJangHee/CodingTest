# 9020 골드바흐의 추측

import math

t = int(input())

for _ in range(t):
    n = int(input())

    array = [True for i in range(n + 1)]
    # 에라토스테네스의 체
    for i in range(2, int(math.sqrt(n)) + 1):
        if array[i]:  # i가 소수인경우
            j = 2
            while i * j <= n:
                array[i * j] = False
                j += 1

    # 파티션만들기
    for i in range(n // 2, 1, -1):
        if array[n - i] and array[i]:
            print(i, n - i)
            break
