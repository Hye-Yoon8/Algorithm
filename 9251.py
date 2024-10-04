# 백준 9251번 - LCS

string_A = input()
string_B = input()

LCS = [[0] * (len(string_B) + 1) for _ in range(len(string_A) + 1)]

for i in range(1, len(string_A)+1):
    for j in range(1, len(string_B)+1):
        if string_A[i-1] == string_B[j-1] :
            LCS[i][j] = LCS[i-1][j-1] + 1
        else:
            LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])

print(max(map(max, LCS)))