def can_reach_end(board, n):
    # DFS 초기 설정
    stack = [(0, 0)]  # 스택을 사용하여 (x, y) 좌표를 넣는다
    visited = [[False] * n for _ in range(n)]  # 방문한 곳을 체크
    visited[0][0] = True  # 시작점 방문 처리

    while stack:
        x, y = stack.pop()  # 스택에서 좌표를 꺼낸다

        # 현재 위치에서 이동 가능한 칸 수
        jump = board[x][y]

        # 승리 지점에 도달
        if jump == -1:
            return "HaruHaru"

        # 오른쪽으로 이동
        if y + jump < n and not visited[x][y + jump]:
            visited[x][y + jump] = True
            stack.append((x, y + jump))

        # 아래로 이동
        if x + jump < n and not visited[x + jump][y]:
            visited[x + jump][y] = True
            stack.append((x + jump, y))

    return "Hing"

# 입력 받기
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

# 결과 출력
print(can_reach_end(board, n))
