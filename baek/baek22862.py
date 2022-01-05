# 가장 긴 짝수 연속한 부분 수열(large)
# https://www.acmicpc.net/problem/22862

from sys import stdin
input = stdin.readline

N, K = map(int, input().split())
S = list(map(int, input().split()))

answer = 0
end = 0
odd = 0
even = 0

for start in range(N):
    while(odd<=K and end <N):
        if S[end] %2 == 1:
            odd += 1
        else :
            even += 1
        end += 1

        if start == 0 and end == N:
            answer = even
            break
    
    if odd == K + 1:
        answer = max(even, answer)

    if S[start] % 2 == 1:
        odd -= 1
    else :
        even -= 1
    

print(answer)
