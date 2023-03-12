# 백준 11726번 - 2×n 타일링

import sys

n = int(sys.stdin.readline())
d = [0] * n

for i in range(n):
    if i == 0:
        d[i] = 1
    elif i == 1:
        d[i] = 2
    else:
        d[i] = d[i - 1] + d[i - 2]

print(d[n-1] % 10007)