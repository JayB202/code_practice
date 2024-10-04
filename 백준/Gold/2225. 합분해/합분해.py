#입력
#     첫줄에 N = 합이 되어야 하는수, K = 더할 수의 개수
#로직
#    N을 K 개의 정수로 나누면 될거 같은데, 
#     덧셈의 순서도 중요하고
#    동일한 수 여러번 사용 가능 
#     dp[i][j] = dp[i-1][j] + dp[i][j-1]!!!
#            dp[i-1][j]: i-1개의 정수로 j를 만들 수 있는 경우의 수.
#            dp[i][j-1]: i개의 정수로 j-1을 만들 수 있는 경우의 수.
#출력
#    N을 K개의 정수로 나누는 경우의 수
MOD = 1000000000

def count_partitions(N, K):
    dp = [[0] * (N + 1) for _ in range(K + 1)]
    
    for i in range(K + 1):
        dp[i][0] = 1  # N이 0일 때, 하나도 더하지 않는 경우는 1가지
    
    # DP 점화식 적용
    for i in range(1, K + 1):
        for j in range(1, N + 1):
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD
    
    return dp[K][N]

# 입력 처리
N, K = map(int, input().split())

# 결과 출력
print(count_partitions(N, K))
