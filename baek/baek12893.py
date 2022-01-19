import sys

"""
적의 적
https://www.acmicpc.net/problem/12893
"""
sys.setrecursionlimit(10 ** 9)


def find(x):
    if p[x] == x:
        return x
    p[x] = find(p[x])
    return p[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return
    p[a] = b


input = sys.stdin.readline

N, M = map(int, input().split())
p = [0] * (N + 1)
enemy = [0] * (N + 1)

for i in range(N + 1):
    p[i] = i

answer = 1

for i in range(M):
    a, b = map(int, input().split())
    a = find(a)
    b = find(b)

    if a == b:
        answer = 0
        break

    ae = enemy[a]
    be = enemy[b]

    if ae != 0:
        union(ae, b)
    else:
        enemy[a] = b

    if be != 0:
        union(be, a)
    else:
        enemy[b] = a

print(answer)

