# 백준 10974번 - 모든 순열
# DFS를 통한 백트래킹 사용

import sys
input = sys.stdin.readline

N = int(input())
Temp = []

def DFS():
    if len(Temp) == N:
        print(*Temp)
        return
    
    for i in range(1, N+1):
        if i not in Temp:
            Temp.append(i)
            DFS()
            Temp.pop()

DFS()