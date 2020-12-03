# 2012 등수 매기기
# 그리디

n = int(input())
grade = []
for _ in range(n):
    grade.append(int(input()))

# 오름차순 정렬
grade.sort()

result = 0
for i in range(1, len(grade)+1):
    result += abs(grade[i-1] - i)

print(result)
