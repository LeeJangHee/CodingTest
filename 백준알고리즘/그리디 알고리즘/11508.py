# 11508 2+1 세일

n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort(reverse=True)
result = 0
for i in range(n):
    if i % 3 == 2:
        continue
    result += arr[i]

print(result)
