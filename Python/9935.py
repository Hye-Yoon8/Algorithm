# 백준 9935번 - 문자열 폭발

string = input()
bomb = input()

stack = []
lastbomb = bomb[-1]
len_bomb = len(bomb)

for char in string:
    stack.append(char)
    if char == lastbomb and ''.join(stack[-len_bomb:]) == bomb:
        del stack[-len_bomb:]

answer = ''.join(stack)

if answer == '':
    print('FRULA')
else:
    print(answer)