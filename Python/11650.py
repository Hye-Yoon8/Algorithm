# 백준 11650번 - 좌표 정렬하기

N = int(input())
xy = []

for i in range(N):
    xy.append(list(map(int, input().split())))
xy.sort()

for i in range(N):
    print(xy[i][0], xy[i][1])