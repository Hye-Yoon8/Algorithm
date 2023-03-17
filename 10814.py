# 백준 10814번 - 나이순 정렬

N = int(input())
M = []

for i in range(N):
    M.append(input().split())

M.sort(key=lambda x : int(x[0]))

for i in range(N):
    print(int(M[i][0]), M[i][1])