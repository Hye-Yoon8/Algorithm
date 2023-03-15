# 백준 1259번 - 팰린드롬수

while(True):
    N = input()
    if int(N) == 0:
        break
    else:
        if N == N[::-1]:
            print("yes")
        else:
            print("no")