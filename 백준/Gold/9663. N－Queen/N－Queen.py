def n_queens(N):
    def solve(row):
        if row == N:
            return 1
        
        count = 0
        for col in range(N):
            if col_used[col] or diag1_used[row - col + N - 1] or diag2_used[row + col]:
                continue
            
            col_used[col] = diag1_used[row - col + N - 1] = diag2_used[row + col] = True
            count += solve(row + 1)
            col_used[col] = diag1_used[row - col + N - 1] = diag2_used[row + col] = False
        
        return count

    col_used = [False] * N
    diag1_used = [False] * (2 * N - 1)
    diag2_used = [False] * (2 * N - 1)
    return solve(0)

# 입력 받기
N = int(input())
print(n_queens(N))
