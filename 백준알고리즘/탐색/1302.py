# 1302 베스트셀러

n = int(input())
book = dict()

for _ in range(n):
    name = input()
    if name not in book:
        book[name] = 1
    else:
        book[name] += 1

target = max(book.values())
array = []

for mBook, number in book.items():
    if number == target:
        array.append(mBook)

print(sorted(array)[0])
