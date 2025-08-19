# 백준 18110번 - solved.ac
# round() 사용 → 틀림

import sys
input = sys.stdin.readline

def my_round(num):
    if num - int(num) < 0.5:
        return int(num)
    else:
        return int(num) + 1

n = int(input())

if n:
    diff = [int(input()) for _ in range(n)]
    diff.sort()

    n_avg = my_round(n * 0.15)

    diff_avg = diff[n_avg : n - n_avg]
    avg = my_round(sum(diff_avg) / len(diff_avg))
    print(avg)
else:
    print(0)