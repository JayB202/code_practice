import sys
input = sys.stdin.readline

n = int(input())
arr = [[n] * n for _ in range(n)]
dist = [0] * n # 각 정점별 가장 먼 거리에 대한 거리 표
for i in range(n):
    for j in range(n):
        if i == j:
            arr[i][j] = 0
while 1:
    a, b = map(int, input().split())
    if [a, b] == [-1, -1]:
        break
    arr[a - 1][b - 1], arr[b - 1][a - 1] = 1, 1

for k in range(n): # k : 중간지점
    for i in range(n):
        for j in range(n):
            # 중간 지점을 통해 이동하는 거리가 더 짧으면 갱신
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
for i in range(n):
    # 각 정점별로 가장 먼 거리를 입력
    dist[i] = max(arr[i])

t = min(dist) 
print(t, dist.count(t))
[print(i + 1, end=" ") if dist[i] == t else None for i in range(n)]