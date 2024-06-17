MOD = 1000000000

def count_stepping_numbers_with_all_digits(N):
    # dp[length][digit][bitmask]
    dp = [[[0] * (1 << 10) for _ in range(10)] for _ in range(N + 1)]
    
    # 초기화: 길이가 1인 경우
    for digit in range(1, 10):
        dp[1][digit][1 << digit] = 1
    
    # DP 테이블 채우기
    for length in range(2, N + 1):
        for digit in range(10):
            for bitmask in range(1 << 10):
                if digit > 0:
                    dp[length][digit][bitmask | (1 << digit)] += dp[length - 1][digit - 1][bitmask]
                    dp[length][digit][bitmask | (1 << digit)] %= MOD
                if digit < 9:
                    dp[length][digit][bitmask | (1 << digit)] += dp[length - 1][digit + 1][bitmask]
                    dp[length][digit][bitmask | (1 << digit)] %= MOD
    
    # 모든 숫자가 포함된 계단 수의 총 개수 계산
    total_count = 0
    for digit in range(10):
        total_count += dp[N][digit][(1 << 10) - 1]
        total_count %= MOD

    return total_count

# 입력 받기
N = int(input().strip())

# 결과 출력
print(count_stepping_numbers_with_all_digits(N))
