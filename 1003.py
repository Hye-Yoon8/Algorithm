# 백준 1003번 - 피보나치 함수

import sys
    
T = int(sys.stdin.readline())

for i in range(T):
    n = int(sys.stdin.readline())
    d = [[0]*2 for _ in range(n+1)]

    for j in range(len(d)):
        if j == 0:
            d[0][0] = 1
        if j == 1:
            d[1][1] = 1
        if j >= 2:
            d[j][0] = d[j-1][0] + d[j-2][0]
            d[j][1] = d[j-1][1] + d[j-2][1]
    
    print(*d[n])