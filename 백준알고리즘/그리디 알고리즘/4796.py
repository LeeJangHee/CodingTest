# 4796 캠핑
# 그리디
count = 1
while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:
        break

    result = 0
    while v > 0:
        if v >= p:
            result += l
        else:
            if v <= l:
                result += v
            else:
                result += l
        v = v - p

    print('Case %d: %d' %(count, result))
    count += 1
