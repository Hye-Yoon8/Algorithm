# 백준 2108번 - 통계학

import sys

N = int(sys.stdin.readline())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))

# 산술 평균
print(round(sum(num) / N))

# 중앙값
num.sort()
print(num[len(num) // 2])

# 최빈값
mode = dict()
for i in num:
    if i in mode:
        mode[i] += 1     # 2번째 들어가는 경우부터는 +1
    else:
        mode[i] = 1      # num을 dic에 넣어주기

MAX = max(mode.values())
MAX_LIST = []
for i in mode:
    if MAX == mode[i]:
        MAX_LIST.append(i)

if len(MAX_LIST) > 1:
    print(MAX_LIST[1])
else:
    print(MAX_LIST[0])


# 범위
print(num[len(num)-1] - num[0])