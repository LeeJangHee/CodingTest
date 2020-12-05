# 1969 DNA
# 그리디

n, m = map(int, input().split())
dna = []
result = ''
hd = 0
for i in range(n):
    dna.append(input())

for i in range(m):
    cnt = [0, 0, 0, 0]
    for j in range(n):
        if dna[j][i] == 'A':
            cnt[0] += 1
        elif dna[j][i] == 'C':
            cnt[1] += 1
        elif dna[j][i] == 'G':
            cnt[2] += 1
        elif dna[j][i] == 'T':
            cnt[3] += 1

    MAX = max(cnt)
    index = cnt.index(MAX)
    if index == 0:
        result += 'A'
    elif index == 1:
        result += 'C'
    elif index == 2:
        result += 'G'
    elif index == 3:
        result += 'T'
    hd += n - MAX
print(result)
print(hd)
