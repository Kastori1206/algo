import sys

input = sys.stdin.readline
dir = ((1, 0), (-1, 0), (0, -1), (0, 1))


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

answer = [0, 0]
visited = [[0 for _ in range(M)] for _ in range(N)]


def bfs(r, c):
    global N, M
    q = []
    visited[r][c] = 1
    q.append((r, c))
    res = 0
    while len(q) != 0:
        cur = q.pop(0)
        res += 1
        for d in dir:
            nr = cur[0] + d[0]
            nc = cur[1] + d[1]

            if nr < 0 or nr >= N or nc < 0 or nc >= M:
                continue
            if visited[nr][nc] == 1:
                continue
            if board[nr][nc] == 0:
                continue

            q.append((nr, nc))
            visited[nr][nc] = 1
    return res


for r in range(N):
    for c in range(M):
        if visited[r][c] == 1 or board[r][c] == 0:
            continue
        answer[0] += 1
        answer[1] = max(answer[1], bfs(r, c))

print(answer[0])
print(answer[1])
