from collections import deque

def solution(board):
    # 방향: 상, 하, 좌, 우
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    n = len(board)
    
    # 비용을 저장하는 2차원 리스트
    costs = [[[float('inf')] * 4 for _ in range(n)] for _ in range(n)]
    queue = deque()
    
    # 시작 위치 (0, 0)에서 출발
    # (x, y, direction, cost) -> direction은 0:상, 1:하, 2:좌, 3:우
    for i in range(4):
        costs[0][0][i] = 0
    queue.append((0, 0, -1, 0))  # 초기 방향은 없음(-1)
    
    while queue:
        x, y, prev_direction, cost = queue.popleft()
        
        for i, (dx, dy) in enumerate(directions):
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                # 비용 계산
                new_cost = cost + 100 if prev_direction == i or prev_direction == -1 else cost + 600
                
                if new_cost < costs[nx][ny][i]:
                    costs[nx][ny][i] = new_cost
                    queue.append((nx, ny, i, new_cost))
    
    return min(costs[n-1][n-1])

# # 예시 테스트
# board = [
#     [0, 0, 0],
#     [0, 0, 0],
#     [0, 0, 0]
# ]
# print(solution(board))  # 출력: 900
