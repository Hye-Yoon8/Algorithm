# 백준 10816번 - 숫자 카드 2

N = int(input())
N_list = list(map(int, input().split()))

M = int(input())
M_list = list(map(int, input().split()))

cnt = {}

for i in N_list:
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1

for i in M_list:
    count = cnt.get(i)
    if count == None:
        print(0, end=" ")
    else:
        print(count, end=" ")