# 백준 1620번 - 나는야 포켓몬 마스터 이다솜

import sys

N, M = map(int, sys.stdin.readline().split())
dict = {}
for i in range(1, N+1):
    dict[str(i)] = sys.stdin.readline().rstrip()
    
dict_reverse = {Values:Keys for Keys, Values in dict.items()}

for i in range(M):
    Q = sys.stdin.readline().rstrip()
    if Q.isdigit():
        print(dict[Q])
    else:
        print(int(dict_reverse[Q]))