s = "baby"

def select(x, str):
    count = []
    for i in range(x, len(str)-1):
        sum_num = 0
        for j in range(i, len(str)):
            if str[i] == str[j]:
                sum_num += 0
            elif sum_num < j - i:
                sum_num = j - i
        count.append(sum_num)

    return sum(count)

def solution(s):
    answer = 0
    for i in range(len(s)):
            answer += select(i, s)

    return answer

print(solution(s))
