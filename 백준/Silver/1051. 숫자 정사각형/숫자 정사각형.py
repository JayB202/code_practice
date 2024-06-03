N, M = map(int, input().split())
rectangle = [input().strip() for _ in range(N)]

# 정사각형의 최대 크기 초기화
max_size = 1

# 가능한 모든 시작점을 (i, j)로 설정하고, 가능한 최대 크기를 시도
for i in range(N):
    for j in range(M):
        current_value = rectangle[i][j]
        # 정사각형의 크기를 점진적으로 늘려가며 검사
        for k in range(1, min(N, M)):
            if i + k < N and j + k < M:
                if (rectangle[i][j] == rectangle[i][j + k] and
                    rectangle[i][j] == rectangle[i + k][j] and
                    rectangle[i][j] == rectangle[i + k][j + k]):
                    max_size = max(max_size, (k + 1) ** 2)

print(max_size)