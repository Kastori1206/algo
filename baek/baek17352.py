import sys

"""
여러분의 다리가 되어 드리겠습니다!
https://www.acmicpc.net/problem/17352
"""
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 9)


def find(x):
    if p[x] == x:
        return x
    p[x] = find(p[x])
    return p[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a != b:
        p[b] = a


N = int(input())
p = [0] * (N + 1)

for i in range(N + 1):
    p[i] = i

for _ in range(N - 2):
    a, b = map(int, input().split())
    union(a, b)

pre = find(1)
for i in range(1, N + 1):
    next = find(i)
    if next != pre:
        print(pre, next)
        break

    pre = next

