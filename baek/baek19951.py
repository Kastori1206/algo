import sys

"""
태상이의 훈련소 생활
https://www.acmicpc.net/problem/19951
"""
input = sys.stdin.readline

N, M = map(int, input().split())

arr = list(map(int, input().split()))
sum = [0] * (N + 1)
for i in range(M):
    a, b, k = map(int, input().split())
    sum[a - 1] += k
    sum[b] -= k


for i in range(1, N + 1):
    sum[i] = sum[i - 1] + sum[i]
for i in range(N):
    print(arr[i] + sum[i], end=" ")

