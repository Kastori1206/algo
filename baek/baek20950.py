import sys

"""
미술가 미미
https://www.acmicpc.net/problem/20950
"""


def go(idx, n):
    global answer, RR, GG, BB
    if n >= 2:
        answer = min(answer, abs(RR // n - R) + abs(GG // n - G) + abs(BB // n - B))

    for i in range(idx + 1, N):
        RR, GG, BB = RR + RGB[i][0], GG + RGB[i][1], BB + RGB[i][2]
        if n < 7:
            go(i, n + 1)
        RR, GG, BB = RR - RGB[i][0], GG - RGB[i][1], BB - RGB[i][2]


input = sys.stdin.readline
N = int(input())
RGB = [list(map(int, input().split())) for _ in range(N)]
R, G, B = map(int, input().split())
RR, GG, BB = 0, 0, 0
answer = 987654321
go(-1, 0)
print(answer)
