# 백준 1874번 - 스택 수열

import sys

n = int(sys.stdin.readline())
result = []
stack = []
cnt = 0
isSame = True

for i in range(n):
    factor = int(sys.stdin.readline())

    while(cnt < factor):
        cnt += 1
        stack.append(cnt)
        result.append("+")
    
    if stack[-1] == factor:
        stack.pop()
        result.append("-")
    else:
        isSame = False

if isSame == False:
    print("NO")
else:
    for i in range(len(result)):
        print(result[i])