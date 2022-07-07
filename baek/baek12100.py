import sys
import itertools
import copy

"""
2048(Easy)
https://www.acmicpc.net/problem/12100
"""


def move(board, dir):
    global answer
    for d in dir:
        if d == 0:
            up(board)
        elif d == 1:
            down(board)
        elif d == 2:
            left(board)
        else:
            right(board)


def up(board):
    for j in range(n):
        cur = 0
        for i in range(1, n):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0

                if board[cur][j] == 0:
                    board[cur][j] = tmp

                elif board[cur][j] == tmp:
                    board[cur][j] *= 2
                    cur += 1

                else:
                    cur += 1
                    board[cur][j] = tmp


def down(board):
    for j in range(n):
        cur = n - 1
        for i in range(n - 2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[cur][j] == 0:
                    board[cur][j] = tmp
                elif board[cur][j] == tmp:
                    board[cur][j] *= 2
                    cur -= 1
                else:
                    cur -= 1
                    board[cur][j] = tmp


def left(board):
    for i in range(n):
        cur = 0
        for j in range(1, n):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][cur] == 0:
                    board[i][cur] = tmp
                elif board[i][cur] == tmp:
                    board[i][cur] *= 2
                    cur += 1
                else:
                    cur += 1
                    board[i][cur] = tmp


def right(board):
    for i in range(n):
        cur = n - 1
        for j in range(n - 2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][cur] == 0:
                    board[i][cur] = tmp
                elif board[i][cur] == tmp:
                    board[i][cur] *= 2
                    cur -= 1
                else:
                    cur -= 1
                    board[i][cur] = tmp


input = sys.stdin.readline
n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

dirs = list(itertools.product(range(0, 4), repeat=5))

answer = 0

for dir in dirs:
    board = copy.deepcopy(arr)
    move(board, dir)
    answer = max(answer, max(map(max, board)))

print(answer)

