# 2630 색종이 만들기

import sys
input = sys.stdin.readline

n = int(input().strip())
arr = [list(map(int, input().split())) for _ in range(n)]

white = 0
blue = 0

def check(x, y, n):
    global white, blue
    temp_cnt = 0
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j]:
                temp_cnt += 1

    if not temp_cnt:
        white += 1
    elif temp_cnt == n**2:
        blue += 1
    else:
        check(x, y, n//2)
        check(x+n//2,y,n//2)
        check(x,y+n//2,n//2)
        check(x+n//2,y+n//2,n//2)
    return
check(0,0,n)
print(white)
print(blue)
