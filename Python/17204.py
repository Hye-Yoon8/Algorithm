# 백준 17204번 - 죽음의 게임

N, M = map(int, input().split())
a = [int(input()) for _ in range(N)]

visited = [False for _ in range(N)]
# 김영기는 시작순서이므로 항상 True
visited[0] = True

# Index번째 사람이 가리키는 사람의 Index = target
target = a[0]

# 보성이까지 가기위해 필요한 step의 수 : 영기의 시작과 함께 while문이 시작이므로 cnt = 1
cnt = 1

while(target != M):
    if visited[target] == True:
        cnt = -1
        break
    else:
        visited[target] = True
        target = a[target]
        cnt += 1

print(cnt)