# 백준 1260번 - DFS와 BFS

import sys
from collections import deque

input = sys.stdin.readline

def DFS(START):
    print(START, end = ' ')
    visited[START] = 1
    for i in graph[START]:
        if visited[i] == 0:
            DFS(i)

def BFS(START):
    dq = deque([START])
    visited[START] = 1
    while dq:
        a = dq.popleft()
        print(a, end = ' ')
        for i in graph[a]:
            if visited[i] == 0:
                dq.append(i)
                visited[i] = 1

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

visited = [0 for _ in range(N + 1)]
DFS(V)

print()

visited = [0 for _ in range(N + 1)]
BFS(V)