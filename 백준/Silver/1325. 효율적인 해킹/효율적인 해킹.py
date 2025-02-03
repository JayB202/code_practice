from collections import deque
import sys
input = sys.stdin.readline

# 입력 받기
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().split())
    graph[B].append(A)

# BFS 탐색 함수 (제너레이터 활용)
def bfs(start):
    queue = deque([start])
    visited = [False] * (N + 1)
    visited[start] = True
    count = 1

    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1

    return count

# 결과 계산
max_cnt = 0
result = []

for i in range(1, N+1):
    cnt = bfs(i)
    if cnt > max_cnt:
        max_cnt = cnt
        result = [i]
    elif cnt == max_cnt:
        result.append(i)

# 정답 출력
print(*result)
