# 11279 최대 힙
# 우선순위 큐

import heapq, sys
input = sys.stdin.readline
n = int(input())
heap = []
for i in range(n):
    x = int(input())
    if x == 0:
        if len(heap) == 0:
            print(0)
            continue

        print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap, (-x, x))
