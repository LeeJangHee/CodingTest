n = 45
n2 = 125


def solution(n):
    answer = 0

    # 3진법
    three_num = []
    tmp = n
    while tmp > 0:
        three_num.append(tmp % 3)
        tmp = tmp // 3


    three_num.reverse()
    for i in range(len(three_num)):
        answer += three_num[i] * (3 ** i)

    return answer

print(solution(n))
