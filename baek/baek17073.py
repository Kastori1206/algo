import sys
import collections

"""
나무 위의 빗물
https://www.acmicpc.net/problem/17073
"""

input = sys.stdin.readline

N, W = map(int, input().split())

graph = collections.defaultdict(int)

for _ in range(N - 1):
    u, v = map(int, input().split())
    graph[u] += 1
    graph[v] += 1

leaf = 0
for i in range(2, N + 1):
    if graph[i] == 1:
        leaf += 1

print(W / leaf)

