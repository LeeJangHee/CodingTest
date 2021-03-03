# 2805 나무자르기
# 이분탐색

n, m = map(int, input().split())
tree = list(map(int, input().split()))

start = 1
end = max(tree)

while start <= end:
    mid = (start + end) // 2
    cut = 0
    # mid 길이 만큼 자르고 남은 나무합
    for num in tree:
        if num >= mid:
            cut += num - mid

    if cut >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)
