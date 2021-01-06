# 삼각달팽이

def solution(n):
    answer = []
    array = [[0] * n for _ in range(n)]
    x, y = -1, 0
    count = 1
    for i in range(n):
        for j in range(i, n):
            if i % 3 == 0:  # Down
                x += 1
            elif i % 3 == 1:  # Right
                y += 1
            elif i % 3 == 2:  # Up
                x -= 1
                y -= 1

            # 넣기
            array[x][y] = count
            count += 1

    # 조합
    for i in range(n):
        for j in range(n):
            if array[i][j] != 0:
                answer.append(array[i][j])
    return answer


n = [4, 5, 6, 7]
for i in n:
    print(solution(i))
