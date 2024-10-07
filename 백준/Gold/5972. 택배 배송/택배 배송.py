import sys
import heapq

# 노드 클래스 정의
class Node:
    def __init__(self, target_node, weight):
        self.target_node = target_node  # 목표 노드
        self.weight = weight              # 간선의 가중치

    # 우선순위 큐에서의 정렬 기준
    def __lt__(self, other):
        return self.weight < other.weight

def main():
    input = sys.stdin.read
    data = input().splitlines()
    
    # 첫 번째 줄에서 N(노드 개수)과 M(간선 개수) 입력받기
    N, M = map(int, data[0].split())

    # 인접 리스트 초기화
    arr = [[] for _ in range(N + 1)]
    
    # 그래프 입력받기
    for i in range(1, M + 1):
        u, v, w = map(int, data[i].split())
        arr[u].append(Node(v, w))
        arr[v].append(Node(u, w))

    # 방문 여부 및 거리 배열 초기화
    visited = [False] * (N + 1)
    dist = [float('inf')] * (N + 1)
    
    # 1번 노드에서 시작
    print(solution(1, N, arr, visited, dist))

def solution(start, end, arr, visited, dist):
    # 우선순위 큐 초기화
    que = []
    heapq.heappush(que, Node(start, 0))
    dist[start] = 0  # 시작 노드의 거리는 0으로 초기화

    while que:
        now_node = heapq.heappop(que)  # 최소 가중치를 가진 노드 추출
        now = now_node.target_node

        if visited[now]:
            continue  # 이미 방문한 노드는 건너뜀

        visited[now] = True  # 현재 노드를 방문 처리

        # 인접 노드 탐색
        for n in arr[now]:
            if not visited[n.target_node] and dist[n.target_node] > dist[now] + n.weight:
                dist[n.target_node] = dist[now] + n.weight  # 최단 거리 갱신
                heapq.heappush(que, Node(n.target_node, dist[n.target_node]))  # 큐에 추가

    return dist[end]  # 목적 노드까지의 최단 거리 반환

if __name__ == "__main__":
    main()
