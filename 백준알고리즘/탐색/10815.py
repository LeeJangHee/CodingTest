# 10815 숫자 카드
# 이분탐색

n = int(input())
array1 = list(map(int, input().split()))
m = int(input())
array2 = list(map(int, input().split()))
array1.sort()

for num in array2:
    start = 0
    end = n - 1
    result = False

    while start <= end:
        mid = (start + end) // 2

        if array1[mid] == num:
            result = True
            break
        elif array1[mid] > num:
            end = mid - 1
        else:
            start = mid + 1

    if result:
        print(1, end=' ')
    else:
        print(0, end=' ')
