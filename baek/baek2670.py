import sys

"""
연속부분최대곱
https://www.acmicpc.net/problem/2670
"""
input = sys.stdin.readline

N = int(input())

arr = [float(input()) for _ in range(N)]

for i in range(1, N):
    arr[i] = max(arr[i], arr[i - 1] * arr[i])

print("%.3f" % (max(arr)))
