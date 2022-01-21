import sys

sys.setrecursionlimit(10 ** 9)
"""
양과 늑대
https://programmers.co.kr/learn/courses/30/lessons/92343
"""


def bfs(info):
    visited = [[False for _ in range(1 << 17)] for _ in range(n)]
    q = []
    q.append((0, 1, 0, 1))
    visited[0][1] = True
    ret = 0

    while len(q) != 0:
        cur = q.pop()
        idx, s, w, v = map(int, cur)  # idx , 양, 늑대, 비트마스크
        ret = max(ret, s)

        for next in adj[idx]:
            ns = 0
            nw = 0
            if not info[next] and not (v & (1 << next)):
                ns = 1
            if info[next] and not (v & (1 << next)):
                nw = 1

            if info[next] and s <= w + nw:
                continue

            nv = v | (1 << next)
            if visited[next][nv]:
                continue

            visited[next][nv] = True
            q.append((next, s + ns, w + nw, nv))

    return ret


def solution(info, edges):
    global answer, adj, n
    answer = 0
    n = len(info)
    adj = [[] for _ in range(n)]
    for edge in edges:
        a, b = edge[0], edge[1]
        adj[a].append(b)
        adj[b].append(a)

    return bfs(info)


info = [0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1]
edges = [
    [0, 1],
    [1, 2],
    [1, 4],
    [0, 8],
    [8, 7],
    [9, 10],
    [9, 11],
    [4, 3],
    [6, 5],
    [4, 6],
    [8, 9],
]

print(solution(info, edges))
