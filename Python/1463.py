# 백준 1463번 - 1로 만들기

import sys

N = int(sys.stdin.readline())
d = [0] * (N + 1)

for i in range(2, N + 1):
    d[i] = d[i - 1] + 1

    if i % 3 == 0:
        d[i] = min(d[i], d[i//3]+1)
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2]+1)
print(d[N])

# cnt = 0
# while(N != 1):
#     while(True):
#         if N == 2 or N == 3:
#             N = int(N / N)
#             cnt += 1
#             break
#         elif (N - 1) % 3 == 0:
#             N = N - 1
#             cnt += 1
#             break
#         elif N % 3 == 0:
#             N = int(N / 3)
#             cnt += 1
#             break
#         elif N % 2 == 0:
#             N = int(N / 2)
#             cnt += 1
#             break
#         else:
#             N = N - 1
#             cnt += 1
#             break
# print("cnt = {0}".format(cnt))