# 1461 도서관
# 그리디 / 우선순위 큐
import heapq

n, m = map(int, input().split(' '))
array = list(map(int, input().split(' ')))
positive = []
negative = []

largest = max(max(array), -min(array))

# 최대 힙(max heap)을 위해 원소를 음수로 구성
for i in array:
    # 책의 위치가 양수
    if i > 0:
        heapq.heappush(positive, -i)
    # 책의 위치가 음수
    else:
        heapq.heappush(negative, i)

result = 0

while positive:
    # 한번에 m개씩 옮길 수 있으므로 m개씩 빼내기
    result += heapq.heappop(positive)
    for _ in range(m - 1):
        if positive:
            heapq.heappop(positive)

while negative:
    result += heapq.heappop(negative)
    for _ in range(m - 1):
        if negative:
            heapq.heappop(negative)

print(-result * 2 - largest)
