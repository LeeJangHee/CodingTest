# 11656 접미사 배열

str_arr = input()
arr = []

for i in range(len(str_arr)):
    arr.append(str_arr[i:len(str_arr)])


for i in sorted(arr):
    print(i)
