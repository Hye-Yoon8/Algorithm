# 백준 2309번 - 일곱 난쟁이

Height = []

for i in range(9):
    Height.append(int(input()))

sum_H = sum(Height)

for i in range(8):
    for j in range(i+1, 9):
        if (sum_H - Height[i] - Height[j]) == 100:
            del Height[j]
            del Height[i]
            Height.sort()
            for k in range(len(Height)):
                print(Height[k])
            exit()