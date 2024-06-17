def longest_decreasing_subsequence(arr):
    n = len(arr)
    dp = [1] * n
    
    for i in range(1, n):
        for j in range(0, i):
            if arr[j] > arr[i]:
                dp[i] = max(dp[i], dp[j] + 1)
    
    return max(dp)

# 입력 받기
N = int(input().strip())
A = list(map(int, input().strip().split()))

# 결과 출력
print(longest_decreasing_subsequence(A))
