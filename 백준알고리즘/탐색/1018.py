# 1018 채스판 다시 칠하기
# 완전 탐색

n, m = map(int, input().split())
array = []

for i in range(n):
    array.append(input())

# 8 * 8 이상 자르기
result = []
for i in range(n - 7):
    for j in range(m - 7):
        cntW = 0
        cntB = 0
        # 체크무늬 비교
        for x in range(i, i + 8):
            for y in range(j, j + 8):
                # 인덱스로 체크무늬 확인 가능
                if (x + y) % 2 == 0:
                    # 흰, 검 바뀌는 개수를 새서
                    # 최소값으로 체스판 만들기 가능
                    if array[x][y] != 'W':
                        cntW += 1
                    if array[x][y] != 'B':
                        cntB += 1
                else:
                    if array[x][y] != 'B':
                        cntW += 1
                    if array[x][y] != 'W':
                        cntB += 1
        result.append(cntW)
        result.append(cntB)

print(min(result))
