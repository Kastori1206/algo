import sys

"""
파이프 옮기기 1
https://www.acmicpc.net/problem/17070
"""
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = 0


def dfs(r, c, d):
    global answer
    if r == N - 1 and c == N - 1:
        answer += 1
        return

    # 가로
    if d == 0 or d == 2:
        if c + 1 < N:
            if arr[r][c + 1] == 0:
                dfs(r, c + 1, 0)
    # 세로
    if d == 1 or d == 2:
        if r + 1 < N:
            if arr[r + 1][c] == 0:
                dfs(r + 1, c, 1)
    # 대각선
    if r + 1 < N and c + 1 < N:
        if arr[r + 1][c] + arr[r][c + 1] + arr[r + 1][c + 1] == 0:
            dfs(r + 1, c + 1, 2)


if arr[N - 1][N - 1] == 1:
    print(0)
else:
    dfs(0, 1, 0)
    print(answer)
