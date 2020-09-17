# 1935 후위 표기식2

import sys 
# A = 65 // Z = 90
n = int(sys.stdin.readline().strip())
k = list(sys.stdin.readline().strip())
stack = []
num = []
for i in range(n):
  x = float(input())
  num.append(x)

for i in k:
  if i == '+':
    op2 = stack.pop()
    op1 = stack.pop()
    stack.append(op1 + op2)
  elif i == '-':
    op2 = stack.pop()
    op1 = stack.pop()
    stack.append(op1 - op2)
  elif i == '*':
    op2 = stack.pop()
    op1 = stack.pop()
    stack.append(op1 * op2)
  elif i == '/':
    op2 = stack.pop()
    op1 = stack.pop()
    stack.append(op1 / op2)
  else:
    stack.append(num[ord(i)-65])

  
print(format(stack.pop(), ".2f"))
