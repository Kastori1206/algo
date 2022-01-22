import sys

"""
단어 맞추기
https://www.acmicpc.net/problem/9081
"""

input = sys.stdin.readline


def next_permu(s):
    i = len(s) - 1
    while i > 0 and s[i - 1] >= s[i]:
        i -= 1
    if i <= 0:
        return False
    j = len(s) - 1
    while s[i - 1] >= s[j]:
        j -= 1

    s[i - 1], s[j] = s[j], s[i - 1]
    j = len(s) - 1

    while i < j:
        s[i], s[j] = s[j], s[i]
        i += 1
        j -= 1

    return True


for t in range(int(input())):
    s = list(map(str, input().rstrip()))
    next_permu(s)
    print("".join(map(str, s)))

