# 1920 수 찾기


n = int(input())
list1 = list(map(int, input().split()))

m = int(input())
list2 = list(map(int, input().split()))

list1.sort()
ans = []

for i in list2:
    check = False
    start = 0
    end = n - 1

    while start <= end:
        mid = (start + end) // 2

        if list1[mid] > i:
            end = mid - 1
        elif list1[mid] < i:
            start = mid + 1
        else:
            check = True
            break

    if check:
        print(1)
    else:
        print(0)
