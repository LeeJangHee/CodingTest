# 10448 유레카 이론
# 완전탐색

from itertools import combinations_with_replacement
# An = n * (n+1) // 2
# combinations_with_replacement : 조합 + 중복가능
n = 1
array = []
while n * (n+1) // 2 <= 1000:
    array.append(n * (n+1) // 2)
    n += 1

t = int(input())
for _ in range(t):
    num = int(input())
    check = False
    nCr = list(combinations_with_replacement(array, 3))
    for i in range(len(nCr)):
        count = sum(nCr[i])
        if count == num:
            check = True
            break
    if check:
        print(1)
    else:
        print(0)
