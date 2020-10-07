# 1080 행렬

import sys

input = sys.stdin.readline

n, m = map(int, input().split())

a = [[0] * m for _ in range(n)]
b = [[0] * m for _ in range(n)]

# a 배열 초기화
for i in range(n):
    x = input()
    for j in range(m):
        a[i][j] = int(x[j])

# b 배열 초기화
for i in range(n):
    y = input()
    for j in range(m):
        b[i][j] = int(y[j])


# a 배열 원소 바꾸기
def change(x, y):
    for i in range(x, x + 3):
        for j in range(y, y + 3):
            a[i][j] = 1 - a[i][j]


# a == b 확인
def check():
    for i in range(n):
        for j in range(m):
            if a[i][j] != b[i][j]:
                return False

    return True


count = 0
for i in range(n - 2):
    for j in range(m - 2):
        if a[i][j] != b[i][j]:
            change(i, j)
            count += 1

if check():
    print(count)
else:
    print(-1)
