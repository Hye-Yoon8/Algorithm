# 백준 10866번 - 덱

import sys
from collections import deque

N = int(sys.stdin.readline())
a = deque()

for i in range(N):
    # input() 사용 -> 시간 초과 발생
    cmd = sys.stdin.readline().split()

    if cmd[0] == "push_front":
        a.appendleft(cmd[1])

    elif cmd[0] == "push_back":
        a.append(cmd[1])
    
    elif cmd[0] == "pop_front":
        if a:
            print(a.popleft())
        else:
            print(-1)
    
    elif cmd[0] == "pop_back":
        if a:
            print(a.pop())
        else:
            print(-1)
    
    elif cmd[0] == "size":
        print(len(a))
    
    elif cmd[0] == "empty":
        if a:
            print(0)
        else:
            print(1)

    elif cmd[0] == "front":
        if a:
            print(a[0])
        else:
            print(-1)

    elif cmd[0] == "back":
        if a:
            print(a[-1])
        else:
            print(-1)