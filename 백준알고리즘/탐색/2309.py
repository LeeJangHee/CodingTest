# 2309 일곱 난쟁이
# 완전정복

from itertools import combinations
array = []

# 난쟁이 키
for _ in range(9):
    array.append(int(input()))

nCr = list(combinations(array, 7))
answer = []
for i in range(len(nCr)):
    count = sum(nCr[i])
    if count == 100:
        answer = nCr[i]
        break


for i in sorted(answer):
    print(i)
