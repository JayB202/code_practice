import sys
import heapq

def main():
    input = sys.stdin.read
    data = input().splitlines()
    
    # 첫 번째 줄: N, M, K, X
    n, m, k, x = map(int, data[0].split())

    # 그래프 초기화
    graph = [[] for _ in range(n + 1)]

    # 간선 정보 입력
    for i in range(1, m + 1):
        a, b = map(int, data[i].split())
        graph[a].append((b, 1))  # a에서 b로 가는 간선 추가 (거리 1)

    # 최단 거리 배열 초기화
    distance = [-1] * (n + 1)
    distance[x] = 0  # 출발 도시의 거리는 0

    # 다익스트라 알고리즘을 위한 우선순위 큐
    queue = []
    heapq.heappush(queue, (0, x))  # (거리, 도시)

    while queue:
        dist, city = heapq.heappop(queue)  # 가장 짧은 거리의 도시 선택

        # 현재 도시와 연결된 모든 도시 확인
        for next_city, weight in graph[city]:
            new_distance = dist + weight
            # 더 짧은 경로가 발견된 경우
            if distance[next_city] == -1 or new_distance < distance[next_city]:
                distance[next_city] = new_distance
                heapq.heappush(queue, (new_distance, next_city))

    # K 거리인 도시 출력
    found = False
    for i in range(1, n + 1):
        if distance[i] == k:
            print(i)
            found = True

    if not found:
        print(-1)

if __name__ == "__main__":
    main()
