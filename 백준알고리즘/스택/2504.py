# 2504 괄호의 값

import sys

stack = sys.stdin.readline().strip()
check = []

for i in stack:
  # i = (, [ push
  if i == '(' or i == '[':
    check.append(i)
  # i = ) 일때
  elif i == ')':
    temp = 0
    while check:
      top = check.pop()
      # pop() -> '(' 일 때
      if top == '(':
        # 숫자, 문자
        if temp == 0:
          check.append(2)
        else:
          check.append(2*temp)
        break
      # 다른 문자일 경우
      elif top == '[':
        print(0)
        exit(0)
      # 숫자인 경우
      else:
        temp += int(top)

  elif i == ']':
    temp = 0
    while check:
      top = check.pop()
      # pop() -> '[' 일 때
      if top == '[':
        # 숫자, 문자
        if temp == 0:
          check.append(3)
        else:
          check.append(3*temp)
        break
      # 다른 문자일 경우
      elif top == '(':
        print('0')
        exit()
      # 숫자인 경우
      else:
        temp += int(top)
      
result = 0

for i in check:
  if i == '(' or i == '[':
    print(0)
    exit(0)
  else:
    result += i

print(result)
