from collections import deque

# 6방향 (위, 아래, 왼쪽, 오른쪽, 앞, 뒤)
dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def bfs(tomato, M, N, H):
    queue = deque()
    # 익은 토마토(1인 칸)들을 모두 큐에 넣는다.
    for z in range(H):
        for y in range(N):
            for x in range(M):
                if tomato[z][y][x] == 1:
                    queue.append((x, y, z))
    
    # BFS 탐색
    while queue:
        x, y, z = queue.popleft()
        
        for i in range(6):
            nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]
            
            # 상자 범위를 벗어나지 않게 검사
            if 0 <= nx < M and 0 <= ny < N and 0 <= nz < H:
                # 익지 않은 토마토(0)인 경우, 익게 만들고 큐에 넣음
                if tomato[nz][ny][nx] == 0:
                    tomato[nz][ny][nx] = tomato[z][y][x] + 1
                    queue.append((nx, ny, nz))

def solution():
    M, N, H = map(int, input().split())
    # 토마토 상자의 정보를 저장하는 3차원 리스트
    tomato = []
    
    for _ in range(H):
        layer = []
        for _ in range(N):
            layer.append(list(map(int, input().split())))
        tomato.append(layer)
    
    # BFS 탐색 실행
    bfs(tomato, M, N, H)
    
    max_days = 0
    for z in range(H):
        for y in range(N):
            for x in range(M):
                if tomato[z][y][x] == 0:  # 익지 않은 토마토가 있으면 -1 출력
                    print(-1)
                    return
                max_days = max(max_days, tomato[z][y][x])
    
    # 최소 일수를 출력, 시작이 1이었으므로 1을 빼줌
    print(max_days - 1 if max_days > 1 else 0)

if __name__ == "__main__":
    solution()
