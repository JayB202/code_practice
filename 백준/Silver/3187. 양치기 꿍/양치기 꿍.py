from collections import deque

# 방향 벡터 (상, 하, 좌, 우)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    
    sheep = 0
    wolf = 0
    
    # 첫 좌표에서 양 또는 늑대를 확인
    if field[x][y] == 'k':
        sheep += 1
    if field[x][y] == 'v':
        wolf += 1
    
    # 인접한 영역을 탐색
    while queue:
        cx, cy = queue.popleft()
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            
            if 0 <= nx < R and 0 <= ny < C and not visited[nx][ny] and field[nx][ny] != '#':
                visited[nx][ny] = True
                queue.append((nx, ny))
                
                if field[nx][ny] == 'k':
                    sheep += 1
                if field[nx][ny] == 'v':
                    wolf += 1
    
    # 영역 내에서 양과 늑대의 수를 비교하여 결과 처리
    if sheep > wolf:
        return sheep, 0
    else:
        return 0, wolf


R, C = map(int, input().split())
field = [list(input()) for _ in range(R)]
visited = [[False] * C for _ in range(R)]

sheepAlive = 0
wolfAlive = 0

# 울타리로 나뉜 각 구역을 탐색
for i in range(R):
    for j in range(C):
        if not visited[i][j] and field[i][j] != '#':
            sheep, wolf = bfs(i, j)
            sheepAlive += sheep
            wolfAlive += wolf

print(sheepAlive, wolfAlive)
