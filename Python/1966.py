# 백준 1966번 - 프린터 큐
# T = 테스트 케이스
# N = 문서의 개수, M = 몇 번째로 인쇄되는지 출력할 문서가 현재 몇 번째에 있는지
# Priority = N개의 문서 각각의 중요도
# Output = Queue의 M번째에 있는 문서가 몇 번째로 출력되는지

import sys
from collections import deque

T = int(sys.stdin.readline())
for i in range(T):
    N, M = map(int, sys.stdin.readline().split())
    Priority = deque(list(map(int, sys.stdin.readline().split())))
    cnt = 0

    while Priority:
        MAX = max(Priority)
        front = Priority.popleft()
        M -= 1

        if MAX == front:
            cnt += 1
            if M < 0:
                print(cnt)
                break
        else:
            Priority.append(front)
            if M < 0:
                M = len(Priority) - 1