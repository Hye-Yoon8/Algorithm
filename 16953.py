# 백준 16953번 - A → B

# 2를 곱한다.
# 1을 수의 가장 오른쪽에 추가한다.

# A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다.
# 만들 수 없는 경우에는 -1을 출력한다.

"""
풀이 1. top-down 방식 (B를 A로 만들기)
"""
A, B = map(int, input().split())
cnt = 1

while(B != A):
    cnt += 1
    tmp = B
    if B % 10 == 1:
        B = B // 10
    elif B % 2 == 0:
        B = B // 2
    
    # 연산이 안되는 경우, 즉 만들 수 없는 경우
    if tmp == B:
        print(-1)
        break

# while문이 break될 경우에는 else가 실행되지 않음
else:
    print(cnt)


"""
풀이 2. BFS 활용
"""
from collections import deque

A, B = map(int, input().split())
q = deque()
q.append((A, 1))

while(q):
    N, T = q.popleft()
    if N > B:   # N이 B보다 크면 q에 append하지 않고 (아래 코드를 실행하지 않고) 다음으로 넘어감
        continue
    if N == B:
        print(T)
        break
    q.append((int(str(N) + "1"), T + 1))
    q.append((N * 2, T + 1))
else:
    print(-1)