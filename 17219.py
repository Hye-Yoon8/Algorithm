# 백준 17219번 - 비밀번호 찾기

import sys

N, M = map(int, sys.stdin.readline().split())
memo = dict()

for i in range(N):
    address, password = sys.stdin.readline().split()
    memo[address] = {password}

for i in range(M):
    search = input()
    print(*memo[search])