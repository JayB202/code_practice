def solution(arrows):
    # 방향 벡터 정의
    direction = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]
    
    # 현재 위치
    current_position = (0, 0)
    # 방문한 정점과 간선을 저장할 집합
    visited_vertices = set()
    visited_edges = set()
    
    # 시작점 추가
    visited_vertices.add(current_position)
    
    # 방의 개수
    rooms = 0
    
    for arrow in arrows:
        for _ in range(2):  # 교차점을 고려해 2번 이동
            next_position = (current_position[0] + direction[arrow][0], current_position[1] + direction[arrow][1])
            
            # 이미 방문한 점이고, 새로운 간선일 경우 방이 하나 추가된다
            if next_position in visited_vertices and (current_position, next_position) not in visited_edges:
                rooms += 1
            
            visited_vertices.add(next_position)
            visited_edges.add((current_position, next_position))
            visited_edges.add((next_position, current_position))
            
            current_position = next_position
    
    return rooms

# 예제 테스트
print(solution([6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]))  # 결과는 3이어야 합니다
