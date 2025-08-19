# 백준 1676번 - 팩토리얼 0의 개수

import math

N = int(input())
N_F = list(str(math.factorial(N)))
cnt = 0
for i in N_F[::-1]:
    if i == '0':
        cnt += 1
    else:
        break
print(cnt)