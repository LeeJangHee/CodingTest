# 1931 회의실 배정
# 끝나는 시간으로 정렬
# 시작 시간으로 정렬
# 총 2번 정렬해야 함
import sys

n = int(sys.stdin.readline())
meeting = []
end = 0
count = 0
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    meeting.append([a, b])

meeting.sort(key=lambda x: (x[1], x[0]))

for i in range(len(meeting)):
    if end <= meeting[i][0]:
        end = meeting[i][1]
        count += 1

print(count)
