# 백준 2231번 - 분해합

N = input()

for i in range(int(N)):
    sum = 0
    i_list = str(i)

    for j in range(len(i_list)):
        sum += int(i_list[j])
    
    if int(N) == i + sum:
        print(i)
        break

    if i == int(N) - 1:
        print(0)

# N = int(input())
# for i in range(1, N + 1):
#     num = sum((map(int, str(i))))
#     sum = i + num

#     if sum == N:
#         print(i)
#         break

#     if i == N:
#         print(0)