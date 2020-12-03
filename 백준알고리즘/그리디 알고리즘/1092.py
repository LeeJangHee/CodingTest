# 1092 배
# 그리디

import sys
n = int(input())
crane = list(map(int, input().split()))
m = int(input())
box = list(map(int, input().split()))

# 박스를 옮길 수 없는 경우
if max(crane) < max(box):
    print(-1)
    sys.exit()

# 크레인이 현재 옮겨야 하는 박스 번호
positions = [0] * n
# 각 박스를 옮겼는지
check = [False] * m
# 내림차순 정렬
box.sort(reverse=True)
crane.sort(reverse=True)

result = 0
count = 0
while True:
    if count == len(box):   # 박스를 다 옮기면 종료
        break
    for i in range(n):  # 모든 크레인에 대하여 각각 처리
        while positions[i] < len(box):
            # 아직 안 옮긴 박스 중 옮길 수 있는 박스 만날 때까지 반복
            if not check[positions[i]] and crane[i] >= box[positions[i]]:
                check[positions[i]] = True
                positions[i] += 1
                count += 1
                break
            positions[i] += 1
    result += 1

print(result)
