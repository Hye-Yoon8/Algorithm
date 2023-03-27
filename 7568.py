# 백준 7568번 - 덩치

N = int(input())
XY = []

for i in range(N):
    XY.append(list(map(int, input().split())))

for i in range(N):
    cnt = 0
    for j in range(N):
        if i != j and XY[i][0] < XY[j][0] and XY[i][1] < XY[j][1]:
            cnt += 1
    print(1 + cnt, end=' ')