def knapsack(N, K, items):
    # dp 배열을 K+1 크기로 초기화, dp[w]는 무게 w일 때의 최대 가치
    dp = [0] * (K + 1)

    # 각 물건에 대해
    for weight, value in items:
        # 무게 K부터 해당 물건의 무게까지 거꾸로 탐색
        for w in range(K, weight - 1, -1):
            # 현재 물건을 포함할 경우의 최대 가치를 계산
            dp[w] = max(dp[w], dp[w - weight] + value)

    return dp[K]

# 입력 부분
N, K = map(int, input().split())
items = [tuple(map(int, input().split())) for _ in range(N)]

# 결과 출력
print(knapsack(N, K, items))
