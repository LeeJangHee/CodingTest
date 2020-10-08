arr1 = [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
zero = 0
one = 0
def check(x, y, n, arr):
    global zero, one
    temp = 0
    for i in range(x, x + n):
        for j in range(y, y + n):
            if arr[i][j]:
                temp += 1

    if not temp:
        zero += 1
    elif temp == n ** 2:
        one += 1
    else:
        check(x, y, n // 2, arr)
        check(x + n//2, y, n // 2, arr)
        check(x, y + n//2, n // 2, arr)
        check(x + n//2, y + n//2, n // 2, arr)
    return


def solution(arr):
    global zero, one
    answer = []
    check(0,0,len(arr), arr)
    answer.append(zero)
    answer.append(one)

    return answer

print(solution(arr1))
