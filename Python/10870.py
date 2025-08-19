# 백준 10870번 - 피보나치 수 5

def Fibo_fun(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return Fibo_fun(n-1) + Fibo_fun(n-2)

n = int(input())
print(Fibo_fun(n))