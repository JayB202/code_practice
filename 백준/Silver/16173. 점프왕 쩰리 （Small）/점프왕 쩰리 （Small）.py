from collections import deque

def can_reach_end(board, n):
    # BFS 초기 설정
    queue = deque([(0, 0)])
    visited = [[False] * n for _ in range(n)]
    visited[0][0] = True

    while queue:
        x, y = queue.popleft()

        # 현재 위치에서 이동 가능한 칸 수
        jump = board[x][y]

        # 승리 지점에 도달
        if jump == -1:
            return "HaruHaru"

        # 오른쪽으로 이동
        if y + jump < n and not visited[x][y + jump]:
            visited[x][y + jump] = True
            queue.append((x, y + jump))

        # 아래로 이동
        if x + jump < n and not visited[x + jump][y]:
            visited[x + jump][y] = True
            queue.append((x + jump, y))

    return "Hing"

# 입력 받기
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

# 결과 출력
print(can_reach_end(board, n))
