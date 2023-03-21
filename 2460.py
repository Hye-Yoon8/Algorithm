# 백준 2460번 - 지능형 기차 2

P = 0
max_P = 0

for i in range(10):
    out_t, in_t = map(int, input().split())
    P = P - out_t + in_t
    max_P = max(P, max_P)

print(max_P)