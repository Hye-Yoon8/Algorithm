# 백준 15829번 - Hashing

L = int(input())
str_list = list(input())
int_list = [(ord(str_list[i]) - 96) for i in range(L)]
sum = 0

for i in range(L):
    sum += (int_list[i] * (31 ** i))
print(sum % 1234567891)