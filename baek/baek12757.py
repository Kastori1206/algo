"""
전설의 JBNU
https://www.acmicpc.net/problem/12757
"""
import sys
import bisect

keys = []
input = sys.stdin.readline


def addKey(key):
    idx = bisect.bisect_left(keys, key)
    keys.insert(idx, key)


def findKey(num):
    val = a.get(num, -1)
    if val != -1:
        return num
    idx = bisect.bisect(keys, num)
    if idx == 0:
        if abs(keys[idx] - num) <= K:
            return keys[idx]
    elif idx == len(keys):
        if abs(num - keys[idx - 1]) <= K:
            return keys[idx - 1]
    else:
        left = num - keys[idx - 1]
        right = keys[idx] - num
        if left == right and left <= K:
            return -2
        if left < right and left <= K:
            return keys[idx - 1]
        if right < left and right <= K:
            return keys[idx]
    return val  # -1


N, M, K = map(int, input().split())
a = {}
for i in range(0, N):
    key, value = map(int, input().split())
    a[key] = value
    addKey(key)

answer = ""
for i in range(0, M):
    temp = list(map(int, input().split()))
    cmd = temp[0]
    if cmd == 1:
        a[temp[1]] = temp[2]
        addKey(temp[1])
    elif cmd == 2:
        key = findKey(temp[1])
        if key >= 0:
            a[key] = temp[2]
    else:
        key = findKey(temp[1])
        if key == -2:
            answer += "?"
        elif key == -1:
            answer += "-1"
        else:
            answer += str(a[key])
        answer += "\n"

print(answer)
