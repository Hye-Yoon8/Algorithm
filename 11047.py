# 백준 11047번 - 동전 0

import sys

N, K = map(int, sys.stdin.readline().split())
A = [int(sys.stdin.readline()) for _ in range(N)]

cnt = 0
for i in reversed(range(N)):
    cnt += (K // A[i])
    K = K % A[i]

print(cnt)