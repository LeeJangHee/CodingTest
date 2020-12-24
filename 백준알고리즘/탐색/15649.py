# 15649 N과 M(1)
# 브루트포스

from itertools import permutations

n, m = map(int, input().split())
array = [i for i in range(1, n+1)]
nPr = permutations(array, m)

for x in nPr:
    for i in range(len(x)):
        print(x[i], end=" ")
    print()

