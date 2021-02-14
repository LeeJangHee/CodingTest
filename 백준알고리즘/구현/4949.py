# 4949 균형잡힌 세상

while True:
    str_world = input()
    stack = []
    flag = True
    for ch in str_world:
        if ch == '(' or ch == '[':
            stack.append(ch)
        elif ch == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                flag = False
                break
        elif ch == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                flag = False
                break
    if str_world == '.':
        break
    print("yes" if flag and not stack else "no")
