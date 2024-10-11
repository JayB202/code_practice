# 입력 : board -> 0 은 뚫린 길, 1 은 막힌 길
# 최소비용 -> BFS 
#   직선 100원, 코너 500원 -> 다익스트라 
# 출력 : 최소 비용

# 최소비용, 혹은 최단거리를 찾는 특수한 알고리즘
#    단순히 최소비용 / 최단거리라면 BFS
#       가중치 주어졌을때. 우리는 다익스트라 를 씀 
#           반복적으로 탐색을 하긴하는데. 현재 큐에서 최단거리/최소비용인 큐를 꺼내서 이 친구를 통해서 다음을 검색해요
#           최단거리//최소비용 인 큐-> 우선순위 큐

#   BFS : 큐를 사용 해서 FIFO  O(V+E)
#   다익스트라 : 우선순위 큐  O((V+E)logV)

import heapq

def solution(board):
    
    N = len(board)
    # 4가지 방향에 대해서 설정
    directions = [(-1,0), (1,0), (0, -1), (0,1)]
    
    # 각 단계에서의 비용을 저장해줄 리스트를 만들어 줄건데 . . .- >3차원 리스트
    costs = [[[float('inf')] * 4 for _ in range(N)] for _ in range(N)]
    
    #우선순위 큐를 초기화 
    queue = [] 
    
    # 
    for i in range(4) : 
        costs[0][0][i] = 0
        heapq.heappush(queue, (0, 0, 0, i)) # 비용, y , x ,directions)- >초기힙을 4개 만들어 줬습니다. 
    
    while queue :
        current_cost, y, x, direction = heapq.heappop(queue)
        
        # 현재 비용보다 이미 더 작은 비용으로 방문한 경험이 있으면 패스
        if current_cost > costs[y][x][direction] : 
            continue
        
        for new_direction, (dy, dx) in enumerate(directions) :
            ny, nx = y + dy, x + dx
            
            # 벽 x 필드 벗어나면 x 
            if not (0<= ny < N  and  0<= nx < N) or board[ny][nx] == 1 :
                continue
                
            # 비용 계산
            if direction == new_direction :  # 직선도로
                new_cost = current_cost + 100
            else :
                new_cost = current_cost + 600
            
            # 비용이 더 적을떄만, 갱신 및 큐에 추가 
            if new_cost < costs[ny][nx][new_direction] :
                costs[ny][nx][new_direction] = new_cost
                heapq.heappush(queue, (new_cost, ny, nx, new_direction))
                
    
    answer = min(costs[N-1][N-1])
    return answer