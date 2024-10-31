import sys

MAX = 30_000_000

class Edge:
    def __init__(self, s, e, t):
        self.s = s
        self.e = e
        self.t = t

def time_travel(n, edges):
    dist = [MAX] * (n + 1)
    dist[1] = 0  # 출발 정점의 거리는 0

    # N-1 회 반복하여 릴렉세이션 수행
    for _ in range(n - 1):
        for edge in edges:
            s = edge.s
            e = edge.e
            t = edge.t
            if dist[e] > dist[s] + t:
                dist[e] = dist[s] + t

    # 사이클 검출
    for edge in edges:
        s = edge.s
        e = edge.e
        t = edge.t
        if dist[e] > dist[s] + t:
            return True  # 사이클 발견

    return False  # 사이클 없음

# 입력 처리
input = sys.stdin.read
data = input().splitlines()

index = 0
TC = int(data[index])  # 테스트 케이스 수
index += 1

results = []
for _ in range(TC):
    n, m, w = map(int, data[index].split())
    index += 1

    edges = []

    # 도로 정보 입력
    for _ in range(m):
        s, e, t = map(int, data[index].split())
        edges.append(Edge(s, e, t))  # 양방향 도로 추가
        edges.append(Edge(e, s, t))
        index += 1

    # 웜홀 정보 입력
    for _ in range(w):
        s, e, t = map(int, data[index].split())
        edges.append(Edge(s, e, -t))  # 웜홀은 방향이 있으므로 음수로 설정
        index += 1

    # 벨만-포드 알고리즘 호출
    if time_travel(n, edges):
        results.append("YES")
    else:
        results.append("NO")

# 결과 출력
for result in results:
    print(result)
