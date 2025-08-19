# 백준 2609번 - 최대공약수와 최소공배수

# import math
# print(math.gcd(A, B)) ← 최대공약수 (Python 3.5부터 사용 가능)
# print(math.lcm(A, B)) ← 최대공배수 (Python 3.9부터 사용 가능)

A, B = map(int, input().split())

def gcd_cal(A, B):
    while B > 0:
        A, B = B, A % B
    return A

def lcm_cal(A, B):
    return A * B // gcd_cal(A, B)

print(gcd_cal(A, B))
print(lcm_cal(A, B))