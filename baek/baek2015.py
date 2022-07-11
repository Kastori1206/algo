from collections import defaultdict
import sys

'''
수들의 합 4
https://www.acmicpc.net/problem/2015
'''

input = sys.stdin.readline

N, K = map(int, input().split())

arr = list(map(int, input().split()))
dic = defaultdict(int)
answer = 0
for i in range(1, len(arr)):
    arr[i] += arr[i - 1]

for i in range(len(arr)):
    if arr[i] == K:
        answer += 1
    answer += dic[arr[i] - K]
    dic[arr[i]] += 1

print(answer)

