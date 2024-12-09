import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

n = int(input().rstrip())
maze = [list(map(int, list(input().rstrip()))) for _ in range(n)]
weights = [[INF] * n for _ in range(n)]
weights[0][0] = 0

# 상, 하, 좌, 우 방향
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 0, 0))  # (변경 횟수, x, y)
    
    while pq:
        cost, x, y = heapq.heappop(pq)
        
        # 끝 방에 도달하면 결과 반환
        if x == n-1 and y == n-1:
            return cost
        
        # 상하좌우로 이동
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            
            # 범위 내에 있을 때만 처리
            if 0 <= nx < n and 0 <= ny < n:
                # 벽인 경우에는 변경 횟수를 1 증가시킴
                new_cost = cost + (1 if maze[nx][ny] == 0 else 0)
                
                # 최소 변경 횟수로 갱신
                if new_cost < weights[nx][ny]:
                    weights[nx][ny] = new_cost
                    heapq.heappush(pq, (new_cost, nx, ny))
    
    return -1  # 도달할 수 없는 경우

# 다익스트라 호출
result = dijkstra()
print(result)
