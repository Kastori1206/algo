import sys
from collections import deque, defaultdict


input = sys.stdin.readline


dir = [
    (1, -1),
    (1, 0),
    (1, 1),
    (0, -1),
    (0, 0),
    (0, 1),
    (-1, -1),
    (-1, 0),
    (-1, 1),
]


def getMinDist(cur):
    global jongsu
    mmin = 987654321
    res = ()
    for d in dir:
        if d == (0, 0):
            continue
        nr = cur[0] + d[0]
        nc = cur[1] + d[1]

        if 0 <= nr < R and 0 <= nc < C:
            if mmin > (abs(nr - int(jongsu[0])) + abs(nc - int(jongsu[1]))):
                mmin = abs(nr - jongsu[0]) + abs(nc - jongsu[1])
                res = (nr, nc)

    return res


robots = []
jongsu = ()
R, C = map(int, input().split())

mmap = [list(input().strip()) for _ in range(R)]

move = list(map(int, input().strip()))
for r in range(R):
    for c in range(C):
        if mmap[r][c] == "I":
            jongsu = (r, c)
        elif mmap[r][c] == "R":
            robots.append((r, c))

queue = deque(robots)
count = 1
flag = False
for d in move:
    r, c = jongsu

    nr = r + dir[d - 1][0]
    nc = c + dir[d - 1][1]

    if mmap[nr][nc] == "R":
        flag = True
        break
    mmap[r][c] = "."
    mmap[nr][nc] = "I"

    jongsu = (nr, nc)

    size = len(queue)
    dic = defaultdict(int)
    for _ in range(size):
        robot = queue.popleft()
        mmap[robot[0]][robot[1]] = "."
        res = getMinDist(robot)
        # 미친아두이노가 종수랑 같은자리
        if res == jongsu:
            flag = True
            break

        dic[res] += 1
    if flag:
        break

    # 미친아두이노 같은곳 폭발
    for key in list(dic.keys()):
        if dic.get(key) == 1:
            queue.append(key)
            mmap[key[0]][key[1]] = "R"

    count += 1


if flag:
    print("kraj", count)
else:
    for r in range(R):
        print("".join(mmap[r]))
