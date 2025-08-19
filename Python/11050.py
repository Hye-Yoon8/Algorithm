# 백준 11050번 - 이항 계수 1

import math

# def do_factorial(num):
#     result = 1
#     for i in range(2, num + 1):
#         result *= i
#     return result

N, K = map(int, input().split())
print(int(math.factorial(N) / (math.factorial(K) * math.factorial(N-K))))
# print(int(do_factorial(N) / ((do_factorial(K)) * (do_factorial(N-K)))))