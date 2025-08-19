# 백준 9012번 - 괄호

import sys

T = int(sys.stdin.readline())

for i in range(T):
    PS = sys.stdin.readline()
    cnt = 0

    if PS[0] == ')' or PS[len(PS)-1] == '(':
        print("NO")
    else:
        for num in range(len(PS)):
            if cnt >= 0:
                if PS[num] == '(':
                    cnt += 1
                elif PS[num] == ')':
                    cnt -= 1
            elif cnt < 0:
                break
    
        if cnt == 0:
            print("YES")
        else:
            print("NO")