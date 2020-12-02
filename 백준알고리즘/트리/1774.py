# 1774 우주신과의 교감
# 최소 스패닝 

import math

# 두 점사이의 거리
def get_distance(p1, p2):
    a = p1[0] - p2[0]
    b = p1[1] - p2[1]
    return math.sqrt((a * a) + (b * b))


def get_parent(parent, n):
    if parent[n] == n:
        return n
    return get_parent(parent, parent[n])

# 두 정점 합칠 때
def union_parent(parent, a, b):
    a = get_parent(parent, a)
    b = get_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 두 정점이 동일한 부모를 가지는지 확인
def find_parent(parent, a, b):
    a = get_parent(parent, a)
    b = get_parent(parent, b)
    if a == b:
        return True
    else:
        return False


edges = []
parent = {}
locations = []
n, m = map(int, input().split())

for _ in range(n):
    x, y = map(int, input().split())
    locations.append((x, y))

length = len(locations)

for i in range(length - 1):
    for j in range(i + 1, length):
        # 모든 간선의 정보 저장
        edges.append((i + 1, j + 1, get_distance(locations[i], locations[j])))

for i in range(1, n + 1):
    parent[i] = i

# 이미 연결되어 있는 간선 = union
for i in range(m):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

# 거리를 기준으로 오름차순
edges.sort(key=lambda data: data[2])

result = 0
# 크루스칼 알고리즘 수행
for a, b, cost in edges:
    if not find_parent(parent, a, b):
        union_parent(parent, a, b)
        result += cost

print("%0.2f" % result)
