def solve():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    m = int(data[0])
    f = list(map(int, data[1:m+1]))
    Q = int(data[m+1])
    
    queries = []
    index = m + 2
    for _ in range(Q):
        n = int(data[index])
        x = int(data[index + 1])
        queries.append((n, x))
        index += 2

    MAX_L = 60  # log2(500,000) < 60

    # 미리 계산된 f^(2^i) 배열
    dp = [[0] * m for _ in range(MAX_L)]
    
    for i in range(m):
        dp[0][i] = f[i] - 1

    for k in range(1, MAX_L):
        for i in range(m):
            dp[k][i] = dp[k-1][dp[k-1][i]]

    # 각 쿼리 처리
    results = []
    for n, x in queries:
        current = x - 1
        for k in range(MAX_L):
            if (n >> k) & 1:
                current = dp[k][current]
        results.append(current + 1)
    
    sys.stdout.write("\n".join(map(str, results)) + "\n")

# 예제 입력을 처리하기 위한 코드 (입력은 표준 입력에서 주어짐)
if __name__ == "__main__":
    solve()