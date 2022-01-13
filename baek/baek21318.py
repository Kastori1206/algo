import sys

"""
피아노 체조
https://www.acmicpc.net/problem/21318
"""
input = sys.stdin.readline

N = int(input())

arr = list(map(int, input().split()))
arr.insert(0, 0)
Q = int(input())
dp = [0] * (N + 1)
answer = ""
for i in range(1, N + 1):
    dp[i] = dp[i - 1]
    if arr[i] < arr[i - 1]:
        dp[i] += 1

for _ in range(Q):
    x, y = map(int, input().split())
    answer += str(dp[y] - dp[x]) + "\n"

print(answer)
