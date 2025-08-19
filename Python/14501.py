# 백준 14501번 - 퇴사

import sys
input = sys.stdin.readline

N = int(input())
T = []
P = []
for _ in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

# 리스트의 인덱스는 0부터 시작된다.
# 즉, N = 7일이면 리스트의 인덱스는 0부터 6까지만 생성된다.
# 아래 반복문 속 if 실행문을 오류없이 실행시키기 위해 N+1만큼의 리스트를 생성한다.
DP = [0 for _ in range(N+1)]

# 퇴사와 가까운 날짜부터 for문을 수행시킨다.
# N = 7 : 7일차의 인덱스 값 = 6
# N = 8 : 8일차의 인덱스 값 = 7
# ...
# 그러므로 N-1부터 시작한다.
for i in range(N-1, -1, -1):
    # 7일차에 2일동안 진행해야 하는 상담을 시작하면 8일에 종료된다.
    # i = 6, T[i] = T[6] = 2, i + T[i] = 8
    # 즉, DATE_CHECK는 (i+1)일에 시작되는 상담이 종료되는 날짜라고 생각하면 된다.
    DATE_CHECK = i + T[i]
    if DATE_CHECK > N:
        DP[i] = DP[i+1]
    else:
        # 1) DP[i]를 실행하지 않고 DP[i+1]만 실행했을 때
        # 2) DP[i]를 실행했을 때 받는 금액 + DP[i] 상담을 했을 때 받을 수 있는 최대 금액
        # 둘 중 더 큰 값을 DP[i]로 지정한다.
        DP[i] = max(DP[i+1], P[i] + DP[DATE_CHECK])

# 결국 가장 큰 값이 DP[0]에 저장된다.
print(DP[0])