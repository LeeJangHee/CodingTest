# 2212 센서
# 그리디
import sys

n = int(input())
k = int(input())
array = list(map(int, input().split()))

if k >= n:
    print(0)
    sys.exit()

# 오름차순 정렬
array.sort()

distances = []
for i in range(1, n):
    distances.append(array[i] - array[i-1])
distances.sort(reverse=True)

for i in range(k-1):
    distances[i] = 0
print(sum(distances))
