import sys

inputs = sys.stdin.readlines()

T = int(inputs[0])

idx = 1
for _ in range(T):
    N = int(inputs[idx])
    idx += 1
    arr = sorted(
        [list(map(int, inputs[idx + x].split())) for x in range(N)], key=lambda x: x[0]
    )
    idx = idx + N
    cnt = 1
    min = arr[0][1]

    for i in range(1, N):
        if arr[i][1] < min:
            min = arr[i][1]
            cnt += 1
    print(cnt)
