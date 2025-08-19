# 백준 2579번 - 계단 오르기
# 사용 알고리즘 - 다이나믹 프로그래밍

import sys

N = int(sys.stdin.readline())
STAIR, SCORE = [0] * (N + 1), [0] * (N + 1)
for i in range(1, N + 1):
    SCORE[i] = int(sys.stdin.readline())

if N <= 2:
    print(sum(SCORE))
    exit()

STAIR[1] = SCORE[1]
STAIR[2] = SCORE[1] + SCORE[2]
for i in range(3, N + 1):
    STAIR[i] = max(STAIR[i-2] + SCORE[i], STAIR[i-3] + SCORE[i-1] + SCORE[i])

print(STAIR[-1])