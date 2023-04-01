# 백준 1654번 - 랜선 자르기

# n)     MID = 201
#        cnt = 3 + 3 + 2 + 2 = 10 < N
#        END = MID - 1 = 200
# n + 1) MID = 200
#        cnt = 4 + 3 + 2 + 2 = 11 = N
#        START = MID + 1 = 201
# ∴ START (= 201) > END (= 200)이니까 while문 실행 종료 → 최댓값 END 출력

import sys

LAN = []
K, N = map(int, sys.stdin.readline().split())
for i in range(K):
    LAN.append(int(sys.stdin.readline()))

START = 1
END = max(LAN)

# START가 END보다 크면 실행 X
while(START <= END):
    cnt = 0     # 랜선의 수
    MID = (START + END) // 2
    
    for i in LAN:
        cnt += i // MID
    
    if cnt < N:     # 랜선의 수가 필요한 개수보다 적으면
        END = MID - 1
    else:           # 랜선의 수가 필요한 개수보다 같거나 많으면
        START = MID + 1

print(END)          # 랜선의 최대 길이를 Print -> END를 출력