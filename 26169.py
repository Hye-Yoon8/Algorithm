# 백준 26169번 - 세 번 이내에 사과를 먹자
# DFS (깊이 우선 탐색) 사용

import sys
input = sys.stdin.readline

def DFS(r, c, board, depth, APPLE):
    global isMoreThan2
    
    visited[r][c] = True

    currentDepth = depth
    currentAPPLE = APPLE

    if depth <= 3 and APPLE >= 2:
        # 다른 경로와 해당 노드를 공유하는 경우를 위해 추가 : 백트래킹
        visited[r][c] = False
        isMoreThan2 = True
        return
    if depth >= 3 and APPLE < 2:
        # 다른 경로와 해당 노드를 공유하는 경우를 위해 추가 : 백트래킹
        visited[r][c] = False
        return

    # up
    if ((r > 0) and (visited[r-1][c] != True) and (board[r-1][c] != -1)):
        if board[r-1][c] == 1:
            DFS(r-1, c, board, currentDepth + 1, currentAPPLE + 1)
        else:
            DFS(r-1, c, board, currentDepth + 1, currentAPPLE)
    
    # down
    if ((r < 4) and (visited[r+1][c] != True) and (board[r+1][c] != -1)):
        if board[r+1][c] == 1:
            DFS(r+1, c, board, currentDepth + 1, currentAPPLE + 1)
        else:
            DFS(r+1, c, board, currentDepth + 1, currentAPPLE)
    
    # left
    if ((c > 0) and (visited[r][c-1] != True) and (board[r][c-1] != -1)):
        if board[r][c-1] == 1:
            DFS(r, c-1, board, currentDepth + 1, currentAPPLE + 1)
        else:
            DFS(r, c-1, board, currentDepth + 1, currentAPPLE)
    
    # right
    if ((c < 4) and (visited[r][c+1] != True) and (board[r][c+1] != -1)):
        if board[r][c+1] == 1:
            DFS(r, c+1, board, currentDepth + 1, currentAPPLE + 1)
        else:
            DFS(r, c+1, board, currentDepth + 1, currentAPPLE)
            
    if currentDepth == 0:
        if isMoreThan2 == True:
            print(1)
        else:
            print(0)


BOARD = []
for _ in range(5):
    BOARD.append(list(map(int, input().split())))

r, c = map(int, input().split())

visited = [[False for _ in range(5)] for _ in range(5)]
isMoreThan2 = False

DFS(r, c, BOARD, 0, 0)