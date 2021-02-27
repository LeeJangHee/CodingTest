# 2812 크게 만들기

n, k = map(int, input().split())
num = list(map(str, input()))
ans, tk = [], k
for i in range(n):
    while tk > 0 and ans and ans[-1] < num[i]:
        ans.pop()
        tk -= 1
    ans.append(num[i])

print(''.join(ans[:n-k]))
