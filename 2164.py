# 백준 2164번 - 카드2

from collections import deque

N = int(input())
card = deque([i+1 for i in range(N)])

while(len(card) != 1):
    card.popleft()
    card.append(card.popleft())

print(card[0])


# Output의 규칙 사용
# [N - (N보다 작은 2의 제곱)] * 2

# cnt = 2
# while(True):
#     if (N == 1 or N == 2):
#         print(N)
#         break
#     cnt *= 2
#     if (cnt >= N):
#         print((N - (cnt // 2)) * 2)
#         break