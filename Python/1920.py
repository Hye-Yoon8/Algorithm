# 백준 1920번 - 수 찾기

import sys

N = int(sys.stdin.readline())
A = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

for i in num:
    if i in A:
        print(1)
    else:
        print(0)