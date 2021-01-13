# 1764 듣보잡
# 이분탐색

n, m = map(int, input().split())
listen = []
watch = []
for _ in range(n):
    listen.append(input())
for _ in range(m):
    watch.append(input())

answer = list(set(listen) & set(watch))

print(len(answer))
for ans in sorted(answer):
    print(ans)
