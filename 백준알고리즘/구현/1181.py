# 1181 단어정렬

n = int(input())

arr = []
for _ in range(n):
    arr.append(input())

arr_sort = dict()
# 길이 -> 사전
for i in range(n):
    arr_sort[arr[i]] = len(arr[i])

for key, value in sorted(arr_sort.items(), key=lambda x: (x[1], x[0])):
    print(key)
