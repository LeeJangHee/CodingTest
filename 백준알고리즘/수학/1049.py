# 1049 기타줄

n, m = map(int, input().split())

min_p, min_c = 1000000, 1000000
for _ in range(m):
    package, one = map(int, input().split())
    min_p = min(min_p, package)
    min_c = min(min_c, one)

answer = []

if min_p > 6 * min_c:
    min_p = 6 * min_c

if (n % 6) * min_c > min_p:
    print(int(n / 6) * min_p + min_p)
else:
    print(int(n / 6) * min_p + int(n % 6) * min_c)
