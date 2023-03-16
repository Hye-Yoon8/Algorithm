# 백준 4153번 - 직각삼각형

import sys

while(True):
    length = list(map(int, sys.stdin.readline().split()))
    if length[0] == 0 and length[1] == 0 and length[2] == 0:
        break
    else:
        length.sort()
        if (length[2]**2) == ((length[0]**2) + (length[1]**2)):
            print("right")
        else:
            print("wrong")