def find_five(board):
    # 방향 설정 (오른쪽, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선)
    dx = [1, 1, 0, -1]
    dy = [0, 1, 1, 1]

    memo = [[[0] * 4 for _ in range(21)] for _ in range(21)]

    def calc(x, y, dir, color):
        nx = x + dx[dir]
        ny = y + dy[dir]

        if 1 <= nx <= 19 and 1 <= ny <= 19 and board[nx][ny] == color:
            if memo[nx][ny][dir] == 0:
                memo[nx][ny][dir] = calc(nx, ny, dir, color)
            return memo[nx][ny][dir] + 1
        return 1

    for j in range(1, 20):
        for i in range(1, 20):
            if board[i][j] != 0:
                for d in range(4):
                    if memo[i][j][d] == 0 and calc(i, j, d, board[i][j]) == 5:
                        return f"{board[i][j]}\n{i} {j}\n"
    return "0"

# 입력 받기
board = [[0] * 21 for _ in range(21)]
for i in range(1, 20):
    row = list(map(int, input().split()))
    for j in range(1, 20):
        board[i][j] = row[j-1]

# 결과 출력
result = find_five(board)
print(result)
