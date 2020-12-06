# 1781 컵라면
# 그리디 / 우선순위 큐
import heapq
n = int(input())
array = []
q = []
for i in range(n):
    a, b = map(int, input().split())
    array.append((a, b))

# 데드라인 기준 오름차순
array.sort()

for i in array:
    a = i[0]
    heapq.heappush(q, i[1])
    if a < len(q):
        heapq.heappop(q)
        
print(sum(q))
