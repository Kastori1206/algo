import sys
from typing import Counter

"""
합이 0
https://www.acmicpc.net/problem/3151
"""
input = sys.stdin.readline

N = int(input())

arr = sorted(list(map(int, input().split())))

cnts = Counter(arr)

answer = 0

for i in range(N):
    l, r = i + 1, N - 1

    while l < r:
        sum = arr[l] + arr[r] + arr[i]

        if sum == 0:
            if arr[l] == arr[r]:
                answer += r - l
            else:
                answer += cnts[arr[r]]
            l += 1
        elif sum > 0:
            r -= 1
        else:
            l += 1

print(answer)
