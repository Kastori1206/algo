import sys
from collections import defaultdict


def dfs(graph, cur, visited):
    visited.add(cur)
    for next in graph[cur]:
        if next in visited:
            continue
        dfs(graph, next, visited)
    return len(visited) - 1


input = sys.stdin.readline

n = int(input())
m = int(input())

graph = defaultdict(list)
visited = set()
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(dfs(graph, 1, visited))

