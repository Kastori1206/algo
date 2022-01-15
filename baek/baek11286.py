import sys
import heapq

"""
절댓값 힙
https://www.acmicpc.net/problem/11286
"""
input = sys.stdin.readline

N = int(input())
pq = []
for i in range(N):
    x = int(input())
    if x == 0:
        if pq:
            print(heapq.heappop(pq)[1])
        else:
            print(0)
    else:
        heapq.heappush(pq, (abs(x), x))

