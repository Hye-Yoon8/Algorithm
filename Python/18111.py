# 백준 18111번 - 마인크래프트

# Python 제출 -> 시간 초과
# PyPy3 제출 -> 맞았습니다!!

# 연산 시간 : else < elif

import sys

N, M, B = map(int, sys.stdin.readline().split())
G = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

H = max(map(max, G))

min_TIME = sys.maxsize
max_HEIGHT = H

while(H >= 0):
    BLOCK = 0
    for n in range(N):
        for m in range(M):
            BLOCK += (H - G[n][m])
            
    if BLOCK > B:
        H -= 1
        continue
    else:
        time = 0
        for n in range(N):
            for m in range(M):
                if H > G[n][m]:
                    time += (H - G[n][m])
                else:
                    time += (2 * (G[n][m] - H))

        if min_TIME > time:
            min_TIME = time
            max_HEIGHT = H
        elif min_TIME == time:
            if max_HEIGHT < H:
                max_HEIGHT = H
        H -= 1
print(min_TIME, max_HEIGHT)