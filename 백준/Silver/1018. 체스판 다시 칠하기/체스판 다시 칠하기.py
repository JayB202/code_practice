N, M = map(int, input().split())
board = [input().strip() for _ in range(N)]

# 패턴 1: 시작이 'W'
pattern1 = [['W', 'B'] * 4,
            ['B', 'W'] * 4] * 4

# 패턴 2: 시작이 'B'
pattern2 = [['B', 'W'] * 4,
            ['W', 'B'] * 4] * 4

def count_repaints(board, pattern, x, y):
    count = 0
    for i in range(8):
        for j in range(8):
            if board[x + i][y + j] != pattern[i][j]:
                count += 1
    return count

min_repaints = float('inf')

for i in range(N - 7):
    for j in range(M - 7):
        repaints1 = count_repaints(board, pattern1, i, j)
        repaints2 = count_repaints(board, pattern2, i, j)
        min_repaints = min(min_repaints, repaints1, repaints2)

print(min_repaints)