def solution(info, edges):
    # 트리를 저장할 리스트 생성
    graph = [[] for _ in range(len(info))]
    for parent, child in edges:
        graph[parent].append(child)
    
    # 최대 양의 수를 저장할 변수
    max_sheep = 0

    def dfs(node, sheep, wolves, path):
        nonlocal max_sheep
        
        # 현재 노드의 동물 수에 따라 갱신
        if info[node] == 0:  # 양일 때
            sheep += 1
        else:  # 늑대일 때
            wolves += 1

        # 만약 늑대가 양보다 많아지면 실패
        if wolves >= sheep:
            return

        # 현재 모은 양의 수가 최대 양의 수보다 많으면 갱신
        max_sheep = max(max_sheep, sheep)
        
        # 현재 노드까지의 경로에 있는 모든 노드 탐색
        for next_node in path + graph[node]:
            dfs(next_node, sheep, wolves, [n for n in path + graph[node] if n != next_node])

    # DFS 탐색 시작 (루트 노드에서 시작)
    dfs(0, 0, 0, [])
    
    return max_sheep

