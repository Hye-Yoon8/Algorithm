# 백준 11723번 - 집합

import sys

S = set()
for i in range(int(sys.stdin.readline())):
    CMD = list(sys.stdin.readline().split())
    
    if CMD[0] == 'add':
        S.add(int(CMD[1]))

    elif CMD[0] == 'remove':
        S.discard(int(CMD[1]))

    elif CMD[0] == 'check':
        print(1 if int(CMD[1]) in S else 0)

    elif CMD[0] == 'toggle':
        if int(CMD[1]) in S:
            S.remove(int(CMD[1]))
        else:
            S.add(int(CMD[1]))

    elif CMD[0] == 'all':
        S = set([i for i in range(1, 21)])

    elif CMD[0] == 'empty':
        S = set()