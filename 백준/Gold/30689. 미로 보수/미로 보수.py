import sys
sys.setrecursionlimit(3000)

# 미로의 세로(N)와 가로(M) 크기
N, M = map(int, input().split())

# 미로의 각 칸에 있는 방향 정보
arr = [input().strip() for _ in range(N)]

# 각 칸에 점프대를 설치하는 비용
cost = [list(map(int, input().split())) for _ in range(N)]

# 방향에 따른 이동 값 설정 (하, 상, 좌, 우)
dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

# 방향 문자와 인덱스 간의 매핑
direction = {'D': 0, 'U': 1, 'L': 3, 'R': 2}

# DFS 탐색 중 방문 여부를 체크하는 배열
visited = [[0] * M for _ in range(N)]

# 사이클 탐색 후 처리 완료 여부를 체크하는 배열
done = [[0] * M for _ in range(N)]

# 사이클을 탈출하는데 필요한 최소 비용
answer = 0

def dfs(py, px):
    global answer
    
    # 현재 칸 방문 표시
    visited[py][px] = 1
    # 현재 칸의 방향을 인덱스로 변환
    dir = direction[arr[py][px]]
    # 방향에 따라 이동할 세로 및 가로 위치
    y = dy[dir] + py
    x = dx[dir] + px
    
    # 미로의 경계를 벗어난 경우 (탈출)
    if x < 0 or y < 0 or x >= M or y >= N:
        done[py][px] = 1
        return
    
    # 현재 위치에서 이동할 다음 위치가 이미 처리된 경우
    if done[y][x] == 1:
        done[py][px] = 1
        return
    # 사이클을 발견한 경우
    elif visited[y][x] == 1:
        sy = y
        sx = x
        cc = float('inf')
        
        # 사이클을 탐색하여 최소 비용을 계산
        while True:
            cc = min(cc, cost[sy][sx])
            d = direction[arr[sy][sx]]
            sy = dy[d] + sy
            sx = dx[d] + sx
            if sy == y and sx == x:
                break
        answer += cc
    else:
        # 다음 위치로 DFS를 계속 진행
        dfs(y, x)
    
    # 현재 칸의 탐색 완료
    done[py][px] = 1

# 미로의 모든 칸을 탐색
for i in range(N):
    for j in range(M):
        if done[i][j] == 0:
            dfs(i, j)

# 최소 비용 출력
print(answer)
