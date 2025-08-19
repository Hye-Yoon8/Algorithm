# 백준 2475번 - 검증수

N = list(map(int, input().split()))
sum = 0

for i in range(5):
    sum += N[i]**2

print(sum % 10)