# 백준 11399번 - ATM

import sys

N = int(input())
P = list(map(int, sys.stdin.readline().split()))
P.sort()

sum = 0
for i in range(1,N+1):
    num = 0
    for j in range(i):
        num += P[j]
    sum += num
print(sum)