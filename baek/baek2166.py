import sys

"""
다각형의 면적
https://www.acmicpc.net/problem/2166
"""
input = sys.stdin.readline

N = int(input())

point = [list(map(int, input().split())) for _ in range(N)]
point.append(point[0])
x, y = 0, 0

answer = 0

for i in range(N):
    x += point[i][0] * point[i + 1][1]
    y += point[i][1] * point[i + 1][0]

answer = round((x - y) / 2, 1)


print(abs(answer))
