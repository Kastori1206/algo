import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
graph = defaultdict(list)

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break

    graph[a].append(b)
    graph[b].append(a)

dist = defaultdict(int)
min_score = 51
candiate = []


def bfs(start):
    global min_score, candiate
    visited = [0] * (N + 1)
    q = []
    q.append(start)
    visited[start] = 1

    while q:
        cur = q.pop(0)
        for next in graph[cur]:
            if visited[next] != 0:
                continue

            q.append(next)
            visited[next] = visited[cur] + 1

        if len(q) == 0:
            score = visited[cur] - 1

            if min_score > score:
                min_score = score
                candiate = [start]
            elif min_score == score:
                candiate.append(start)


for i in range(1, N + 1):
    bfs(i)

print(min_score, len(candiate))
print(*candiate)
