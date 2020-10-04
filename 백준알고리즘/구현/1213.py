# 1213 팰린드롬 만들기

import sys

input = sys.stdin.readline

name = input().strip()
name_cnt = [0]*26

# 알파벳 갯수 새기
for i in name:
    name_cnt[ord(i) - 65] += 1

count = 0
odd_alphabet = ''
alphabet = ''
for i in range(26):
    if name_cnt[i] % 2 == 1:
        count += 1
        odd_alphabet += chr(i+65)
    alphabet += chr(i+65) * (name_cnt[i] // 2)

if count > 1:
    print("I'm Sorry Hansoo")
else:
    print(alphabet+odd_alphabet+alphabet[::-1])
