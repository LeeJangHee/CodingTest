# 1149 RGB거리

n = int(input())
home = [list(map(int, input().split())) for _ in range(n)]


for i in range(1, len(home)):
    # 빨 -> 초 or 파
    home[i][0] = min(home[i-1][1], home[i-1][2]) + home[i][0]
    # 초 -> 빨 or 파
    home[i][1] = min(home[i-1][0], home[i-1][2]) + home[i][1]
    # 파 -> 빨 or 초
    home[i][2] = min(home[i-1][0], home[i-1][1]) + home[i][2]

print(min(home[n-1][0], home[n-1][1], home[n-1][2]))
