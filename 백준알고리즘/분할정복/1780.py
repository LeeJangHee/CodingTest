# 1780 종이의 개수
# 분할정복

n = int(input())
array = [list(map(int, input().split())) for _ in range(n)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

answer = {-1: 0, 0: 0, 1: 0}
count1 = 0
count2 = 0
count3 = 0


def check(x, y, size):
    global count1, count2, count3
    # 모두 같은지 확인하기
    # 만약 틀리면 각 변을 9칸으로 나누기
    num = array[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if num != array[i][j]:
                # 9칸 나누기
                for a in range(3):
                    for b in range(3):
                        check(x + size // 3 * a, y + size // 3 * b, size // 3)
                return

    if num == -1:
        count1 += 1
    elif num == 0:
        count2 += 1
    elif num == 1:
        count3 += 1


check(0, 0, n)
print(count1)
print(count2)
print(count3)
