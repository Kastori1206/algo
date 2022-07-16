import sys

"""
다이나믹 룰러
https://www.acmicpc.net/problem/17393
"""
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

answer = []

for i in range(N):
    target = A[i]
    l, r = i + 1, N - 1
    res = i

    while l <= r:
        mid = (l + r) // 2
        if B[mid] > target:
            r = mid - 1
        else:
            l = mid + 1
            res = mid

    answer.append(str(res - (i + 1) + 1))

print(" ".join(answer))

