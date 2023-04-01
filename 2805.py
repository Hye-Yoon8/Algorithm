# 백준 2805번 - 나무 자르기

import sys

N, M = map(int, sys.stdin.readline().split())
Tree = list(map(int, sys.stdin.readline().split()))

START = 0
END = max(Tree)

while(START <= END):
    MID = (START + END) // 2
    TOTAL = 0

    for i in Tree:
        # i < MID인 경우 음수값이 나오므로 i >= MID인 경우만 더해주기
        if i >= MID:
            TOTAL += (i - MID)
    
    if TOTAL < M:
        END = MID - 1
    else:
        START = MID + 1

print(END)