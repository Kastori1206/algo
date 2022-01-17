import sys

"""
사과나무
https://www.acmicpc.net/problem/20002
"""
input = sys.stdin.readline

N = int(input())

sum = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    apple = list(map(int, input().split()))
    for j in range(1, N + 1):
        sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + apple[j - 1]

answer = sum[0][0]
for k in range(N):
    for i in range(1, N + 1 - k):
        for j in range(1, N + 1 - k):
            res = (
                sum[i + k][j + k]
                - sum[i - 1][j + k]
                - sum[i + k][j - 1]
                + sum[i - 1][j - 1]
            )
            answer = max(answer, res)

print(answer)
