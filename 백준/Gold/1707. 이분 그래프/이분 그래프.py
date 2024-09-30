import sys
from collections import deque

# 입력 최적화
input = sys.stdin.read

def is_bipartite_graph(V, graph):
    # 정점 색깔을 표시하는 리스트, 0은 방문하지 않음을 의미
    colors = [0] * (V + 1)
    
    # 모든 정점에 대해 확인해야 한다. (연결 그래프가 아닐 수도 있기 때문)
    for start in range(1, V + 1):
        if colors[start] == 0:  # 아직 방문하지 않은 경우
            # BFS 탐색
            queue = deque([start])
            colors[start] = 1  # 첫 번째 정점을 1로 색칠
            
            while queue:
                node = queue.popleft()
                
                for neighbor in graph[node]:
                    if colors[neighbor] == 0:  # 아직 방문하지 않았다면
                        colors[neighbor] = -colors[node]  # 다른 색으로 칠하기
                        queue.append(neighbor)
                    elif colors[neighbor] == colors[node]:  # 인접한 두 정점이 같은 색이라면
                        return False  # 이분 그래프가 아님
    return True  # 이분 그래프

def main():
    # 입력 데이터를 모두 읽기
    data = input().splitlines()
    idx = 0
    K = int(data[idx])
    idx += 1
    results = []
    
    for _ in range(K):
        V, E = map(int, data[idx].split())
        idx += 1
        graph = [[] for _ in range(V + 1)]  # 그래프를 인접 리스트로 표현
        
        for _ in range(E):
            u, v = map(int, data[idx].split())
            graph[u].append(v)
            graph[v].append(u)
            idx += 1
        
        # 각 테스트 케이스에 대해 이분 그래프 여부 확인
        if is_bipartite_graph(V, graph):
            results.append("YES")
        else:
            results.append("NO")
    
    # 결과 출력
    sys.stdout.write("\n".join(results) + "\n")

if __name__ == "__main__":
    main()
