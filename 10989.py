# 백준 10989번 - 수 정렬하기 3

import sys

N = int(sys.stdin.readline())
arr = [0]*10000

for i in range(N):
    a = int(sys.stdin.readline())
    arr[a - 1] += 1
    
for i in range(10000):
    if arr[i] != 0:
        for j in range(arr[i]):
            print(i + 1)