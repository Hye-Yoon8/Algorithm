# 백준 1764번 - 듣보잡

import sys

N, M = map(int, sys.stdin.readline().split())
NO_HEAR = set(sys.stdin.readline().strip() for _ in range(N))
NO_SEE = set(sys.stdin.readline().strip() for _ in range(M))

# set의 & : 교집합
NO_ = sorted(list(NO_HEAR & NO_SEE))
print(len(NO_))
print(*NO_, sep='\n')