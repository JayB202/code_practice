def find_five(board):
    # 방향 설정 (오른쪽, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선)
    dx = [1, 1, 0, -1]
    dy = [0, 1, 1, 1]

    # 메모이제이션을 위한 3차원 리스트 초기화
    memo = [[[0] * 4 for _ in range(19)] for _ in range(19)]

    def calc(x, y, dir, color):
        # 다음 위치 계산
        nx = x + dx[dir]
        ny = y + dy[dir]

        # 보드 범위 내에서 동일한 색의 바둑알이 있는 경우
        if 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
            # 아직 계산되지 않은 경우 재귀적으로 계산
            if memo[nx][ny][dir] == 0:
                memo[nx][ny][dir] = calc(nx, ny, dir, color)
            return memo[nx][ny][dir] + 1
        return 1

    # 보드 탐색
    for j in range(19):
        for i in range(19):
            # 바둑알이 있는 경우
            if board[i][j] != 0:
                for d in range(4):
                    # 메모이제이션이 안된 경우와 연속된 바둑알이 5개인 경우 체크
                    if memo[i][j][d] == 0 and calc(i, j, d, board[i][j]) == 5:
                        # 앞뒤에 같은 색 바둑알이 있는지 확인
                        prev_x, prev_y = i - dx[d], j - dy[d]
                        next_x, next_y = i + 5 * dx[d], j + 5 * dy[d]
                        if 0 <= prev_x < 19 and 0 <= prev_y < 19 and board[prev_x][prev_y] == board[i][j]:
                            continue
                        if 0 <= next_x < 19 and 0 <= next_y < 19 and board[next_x][next_y] == board[i][j]:
                            continue
                        # 결과 반환 (바둑알 색, 위치)
                        return f"{board[i][j]}\n{i + 1} {j + 1}\n"
    return "0"

# 입력 받기
board = [[0] * 19 for _ in range(19)]
for i in range(19):
    row = list(map(int, input().split()))
    for j in range(19):
        board[i][j] = row[j]

# 결과 출력
result = find_five(board)
print(result)
