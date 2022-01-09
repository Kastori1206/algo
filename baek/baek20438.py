import sys

"""
출석체크
https://www.acmicpc.net/problem/20438
"""
input = sys.stdin.readline

N, K, Q, M = map(int, input().split())

sleep = [0] * (N + 3)
check = [0] * (N + 3)

for i in map(int, input().split()):
    sleep[i] = 1
for i in map(int, input().split()):
    if sleep[i]:
        continue
    for j in range(i, N + 3, i):
        if not sleep[j]:
            check[j] = 1

prefix = [check[0]]
for i in range(1, N + 3):
    prefix.append(prefix[-1] + check[i])

for _ in range(M):
    s, e = map(int, input().split())
    print(e - s + 1 - (prefix[e] - prefix[s - 1]))

