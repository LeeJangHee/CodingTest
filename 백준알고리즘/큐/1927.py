# 1927 최소 힙
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

        print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)
