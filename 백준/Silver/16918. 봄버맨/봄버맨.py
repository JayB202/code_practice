import sys
input = sys.stdin.readline

R, C, N = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]

def detonate(board):
    new_board = [['O'] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if board[i][j] == 'O':
                new_board[i][j] = '.'
                for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
                    ni, nj = i + dx, j + dy
                    if 0 <= ni < R and 0 <= nj < C:
                        new_board[ni][nj] = '.'
    return new_board

if N == 0 or N == 1:
    result = grid
elif N % 2 == 0:
    result = [['O'] * C for _ in range(R)]
else:
    first = detonate(grid)
    second = detonate(first)
    result = first if N % 4 == 3 else second

for row in result:
    print(''.join(row))
