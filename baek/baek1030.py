import sys

"""
프렉탈 평면
https://www.acmicpc.net/problem/1030
"""

input = sys.stdin.readline


def dfs(len, r, c):
    if len == 1:
        return 0
    center = len // N
    if (
        center * (N - K) // 2 <= r < center * (N + K) // 2
        and center * (N - K) // 2 <= c < center * (N + K) // 2
    ):
        return 1

    return dfs(center, r % center, c % center)


s, N, K, R1, R2, C1, C2 = map(int, input().split())

len = N ** s

for r in range(R1, R2 + 1):
    for c in range(C1, C2 + 1):
        print(dfs(len, r, c), end="")
    print()
