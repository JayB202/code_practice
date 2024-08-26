def count_floorboards(N, M, floor):
    visited = [[False] * M for _ in range(N)]
    count = 0
    
    def dfs(x, y, symbol):
        if symbol == '-':
            while y < M and floor[x][y] == '-' and not visited[x][y]:
                visited[x][y] = True
                y += 1
        elif symbol == '|':
            while x < N and floor[x][y] == '|' and not visited[x][y]:
                visited[x][y] = True
                x += 1
    
    for i in range(N):
        for j in range(M):
            if not visited[i][j]:
                count += 1
                dfs(i, j, floor[i][j])
    
    return count

# 입력 받기
N, M = map(int, input().split())
floor = [input().strip() for _ in range(N)]

# 결과 출력
print(count_floorboards(N, M, floor))
