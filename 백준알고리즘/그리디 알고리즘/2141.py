# 2141 우체국

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

arr.sort()
p = [arr[0][1]]
for i in range(1, n):
    p.append(p[i - 1] + arr[i][1])

start = 0
end = n - 1
count = int(1e9)
while start <= end:
    mid = (start + end) // 2
    left = p[mid]
    right = p[n - 1] - p[mid]
    if left >= right:
        end = mid - 1
        count = min(count, arr[mid][0])
    else:
        start = mid + 1

print(count)
