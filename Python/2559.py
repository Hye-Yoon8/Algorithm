# 백준 2559번 - 수열

import sys

N, K = map(int, sys.stdin.readline().split( ))
temp = list(map(int, sys.stdin.readline().split()))

sum_list = []
sum_list.append(sum(temp[:K]))

for i in range(N - K):
    sum_list.append(sum_list[i] - temp[i] + temp[i + K])

print(max(sum_list))