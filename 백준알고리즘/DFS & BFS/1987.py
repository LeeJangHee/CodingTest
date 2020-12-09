# 1987 알파벳
# 백트레킹

# move
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    global result
    # 동일한 경우 1번 계산 ==> 집합(Set) 사용
    q = set()
    q.add((x, y, array[x][y]))
    while q:
        x, y, step = q.pop()
        # 가잔 긴 거리 저장
        result = max(result, len(step))

        # 이동하는 경우
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 이동할 수 없고 새로운 알파벳
            if (0 <= nx < r and 0 <= ny < c and
                    array[nx][ny] not in step):
                q.add((nx, ny, step + array[nx][ny]))


# 전체 데이터
r, c = map(int, input().split())
array = []
for _ in range(r):
    array.append(input())

# 백트레킹
result = 0
bfs(0, 0)
print(result)
