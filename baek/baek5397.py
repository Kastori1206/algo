import sys
from collections import deque

"""
키로거
https://www.acmicpc.net/problem/5397
"""
input = sys.stdin.readline

N = int(input())
for t in range(N):
    log = list(input().strip())
    l, r = deque(), deque()
    for key in log:
        if key == "-":
            if l:
                l.pop()
        elif key == "<":
            if l:
                r.appendleft(l.pop())
        elif key == ">":
            if r:
                l.append(r.popleft())
        else:
            l.append(key)

    l.extend(r)
    print("".join(l))

