# 백준 1929번 - 소수 구하기

# 에라토스테네스의 체
# 구하고자 하는 수열의 마지막 숫자의 제곱근까지만 약수의 여부를 검증
# ex) 1 ~ 120 → 11² > 120이므로 11보다 작은 수의 배수들만 지우면 됨
# ex) 1 ~ 200 → 15² > 200이므로 15보다 작은 수의 배수들만 지우면 됨

M, N = map(int, input().split())

for i in range(M, N + 1):
    if i == 1:
        continue

    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            break

    else:
        print(i)