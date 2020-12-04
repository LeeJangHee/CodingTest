# 1449 수리공 항승
# 그리디

n, l = map(int, input().split())
array = list(map(int, input().split()))
array.sort()
result = 0
count = 0
for i in array:
    if result < i:
        count += 1
        result = i + l - 1
print(count)
