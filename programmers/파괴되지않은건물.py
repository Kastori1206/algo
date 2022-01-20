import sys

"""
파괴되지 않은 건물
https://programmers.co.kr/learn/courses/30/lessons/92344?language=python3
"""


def solution(board, skill):
    answer = 0
    R, C = len(board), len(board[0])
    mat = [[0] * (C + 1) for _ in range(R + 1)]

    for s in skill:
        type, r1, c1, r2, c2, degree = map(int, s)
        if type == 1:
            mat[r1][c1] -= degree
            mat[r2 + 1][c2 + 1] -= degree
            mat[r1][c2 + 1] += degree
            mat[r2 + 1][c1] += degree

        else:
            mat[r1][c1] += degree
            mat[r2 + 1][c2 + 1] += degree
            mat[r1][c2 + 1] -= degree
            mat[r2 + 1][c1] -= degree

    for r in range(0, R + 1):
        for c in range(1, C + 1):
            mat[r][c] += mat[r][c - 1]

    for c in range(0, C + 1):
        for r in range(1, R + 1):
            mat[r][c] += mat[r - 1][c]

    for r in range(R):
        for c in range(C):
            board[r][c] += mat[r][c]
            if board[r][c] > 0:
                answer += 1

    return answer


board = [[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]]
skill = [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]

print(solution(board, skill))
