# 1758 알바생 강호

n = int(input())
people = []

for _ in range(n):
    people.append(int(input()))

people.sort(reverse=True)
result = 0
for i in range(n):
    money = people[i] - i
    if money > 0:
        result += money

print(result)
