# 백준 1085번 - 직사각형에서 탈출

x, y, w, h = map(int, input().split())

width = min(w - x, x)
height = min(h - y, y)
print(min(width, height))