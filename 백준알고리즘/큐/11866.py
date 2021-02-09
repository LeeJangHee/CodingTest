# 11866 요세푸스 문제0

from collections import deque

n, k = map(int, input().split())
q = deque([i for i in range(1, n+1)])
ans = []
# n = 명수 / k = 죽는 사람의 index 번호
idx = 0
while q:
    idx += 1
    x = q.popleft()

    if idx % k == 0:
        ans.append(x)
    else:
        q.append(x)

print("<", end="")
for i in range(len(ans)):
    if i == len(ans) - 1:
        print(ans[i], end=">")
    else:
        print(ans[i], end=", ")
