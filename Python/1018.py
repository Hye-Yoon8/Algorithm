# 백준 1018번 - 체스판 다시 칠하기

N, M = map(int, input().split())
Board = []  # 사용자가 입력한 색을 저장할 리스트
Num = []    # 결과값을 저장하기 위한 리스트

for i in range(N):
    Board.append(input())

# N-7, M-7 : 8x8 ... 시작점은 전체 길이에서 -7을 한 지점까지만 가능
for i in range(N-7):
    for j in range(M-7):
        start_B = 0     # 시작점이 B로 시작하는 경우
        start_W = 0     # 시작점이 W로 시작하는 경우

        # 시작점 i, j에서부터 +8까지의 영역까지 다시 칠하기 작업
        for row in range(i, i+8):
            for column in range(j, j+8):
                if (row + column) % 2 == 0: # row + column이 짝수일때
                    if Board[row][column] != 'B':
                        start_B += 1
                    if Board[row][column] != 'W':
                        start_W += 1
                else: # row + column이 홀수일때
                    if Board[row][column] != 'W':
                        start_B += 1
                    if Board[row][column] != 'B':
                        start_W += 1

        Num.append(min(start_B, start_W))

print(min(Num))