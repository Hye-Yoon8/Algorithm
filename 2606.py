# 백준 2606번 - 바이러스
# DFS (깊이 우선 탐색) 사용

def DFS(start):
    visited[start] = 1
    for i in graph[start]:
        if visited[i] == 0:
            DFS(i)


N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

DFS(1)
print(sum(visited) - 1)