# 15903 카드 합체 놀이

n, m = map(int, input().split())

cards = list(map(int, input().split()))

cards.sort()
for i in range(m):
    x, y = cards[0], cards[1]
    cards[0] = cards[1] = x + y
    cards.sort()

print(sum(cards))
