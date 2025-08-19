# 백준 10773번 - 제로

K = int(input())
num = []

for i in range(K):
    n = int(input())
    if n == 0:
        num.pop()
    else:
        num.append(n)

print(sum(num))