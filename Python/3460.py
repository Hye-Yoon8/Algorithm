# 백준 3460번 - 이진수

T = int(input())
for i in range(T):
    n = int(input())
    n_bin = bin(n)
    num = []

    for j in range(len(n_bin)-1, -1, -1):
        if n_bin[j] == '1':
            num.append(len(n_bin) -1 - j)

    print(*num)