# 백준 11866번 - 요세푸스 문제 0

from collections import deque

N, K = map(int, input().split())
queue = deque()
result = []

for i in range(1, N + 1):
    queue.append(i)

while queue:
    for i in range(K - 1):
        queue.append(queue.popleft())
    result.append(queue.popleft())

print("<", end='')
print(', '.join(map(str,result)), end='')
print(">")

# circle = [1 for i in range(N+1)]
# circle[0] = 0
# num = 0
# num_list = []

# while(1 in circle):
#     cnt = 0
#     while(cnt != K):
#         num += 1
#         if num > N:
#             num = int(num % N)
#         if circle[num] == 1:
#             cnt += 1
#     circle[num] = 0
#     num_list.append(num)

# for i in range(len(num_list)):
#     if i == 0:
#         print("<{0}".format(num_list[i]), end = ", ")
#     elif i == (len(num_list) - 1):
#         print("{0}>".format(num_list[i]))
#     else:
#         print(num_list[i], end = ", ")