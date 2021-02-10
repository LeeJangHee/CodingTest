# 16953 A->B

from collections import deque
a, b = map(int, input().split())

# 1. A*2
# 2. 오른쪽 -> 1

ans = -1
q = deque([(a, 1)])

while q:
    x, count = q.popleft()
    if x == b:
        ans = count
        break

    if x*2 <= b:
        q.append((x*2, count+1))
    if int(str(x)+'1') <= b:
        q.append((int(str(x)+'1'), count+1))

print(ans)
