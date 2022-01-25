import sys

"""
숫자구술
https://www.acmicpc.net/problem/2613
"""


def check(mid):
    cnt = 1
    sum = 0
    for num in arr:
        sum += num
        if sum > mid:
            cnt += 1
            sum = num

    return cnt <= M


input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
l = max(arr)
r = sum(arr)
while l <= r:
    mid = (l + r) // 2

    if check(mid):
        r = mid - 1
    else:
        l = mid + 1

sum, cnt = 0, 0
res = []

for i in range(N):
    sum += arr[i]
    if sum > l:
        sum = arr[i]
        M -= 1
        res.append(cnt)
        cnt = 0
    cnt += 1
    if N - i == M:
        break

while M:
    res.append(cnt)
    cnt = 1
    M -= 1

print(l)
print(*res)
