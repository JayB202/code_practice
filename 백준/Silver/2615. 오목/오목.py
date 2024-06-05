def initialize_board():
    """바둑판을 초기화하고 입력을 받아 19x19 부분에 값을 채운다."""
    board = [[0] * 21 for _ in range(21)]
    for i in range(1, 20):
        row = list(map(int, input().split()))
        for j in range(1, 20):
            board[i][j] = row[j-1]
    return board

def calculate_stones(board, x, y, dir, color, memo, dx, dy):
    """지정된 방향으로 같은 색의 바둑알이 몇 개 연속으로 있는지 계산한다."""
    nx = x + dx[dir]
    ny = y + dy[dir]

    # 보드 범위 내에서 동일한 색의 바둑알이 있는 경우
    if 1 <= nx <= 19 and 1 <= ny <= 19 and board[nx][ny] == color:
        if memo[nx][ny][dir] == 0:
            memo[nx][ny][dir] = calculate_stones(board, nx, ny, dir, color, memo, dx, dy)
        return memo[nx][ny][dir] + 1
    return 1

def find_winner(board):
    """보드를 탐색하여 승자를 찾는다."""
    dx = [1, 1, 0, -1]
    dy = [0, 1, 1, 1]
    memo = [[[0] * 4 for _ in range(21)] for _ in range(21)]

    for j in range(1, 20):
        for i in range(1, 20):
            if board[i][j] != 0:
                for d in range(4):
                    if memo[i][j][d] == 0 and calculate_stones(board, i, j, d, board[i][j], memo, dx, dy) == 5:
                        prev_x, prev_y = i - dx[d], j - dy[d]
                        next_x, next_y = i + 5 * dx[d], j + 5 * dy[d]
                        if 1 <= prev_x <= 19 and 1 <= prev_y <= 19 and board[prev_x][prev_y] == board[i][j]:
                            continue
                        if 1 <= next_x <= 19 and 1 <= next_y <= 19 and board[next_x][next_y] == board[i][j]:
                            continue
                        return board[i][j], i, j
    return 0, -1, -1

def print_result(winner, x, y):
    """결과를 출력한다."""
    print(winner)
    if winner != 0:
        print(f"{x} {y}")

def main():
    """메인 함수."""
    board = initialize_board()
    winner, x, y = find_winner(board)
    print_result(winner, x, y)

if __name__ == "__main__":
    main()
