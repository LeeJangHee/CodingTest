# 2003 수들의 합 2

n, m = map(int, input().split())

arr = list(map(int, input().split()))
count = 0
m_sum = 0
end = 0

for start in range(n):
    while m_sum < m and end < n:
        m_sum += arr[end]
        end += 1

    if m_sum == m:
        count += 1
    m_sum -= arr[start]

print(count)
