def max_stepping_stones(N):
    left, right = 1, int((2 * N) ** 0.5) + 1
    max_steps = 1

    while left <= right:
        mid = (left + right) // 2
        sum_mid = mid * (mid + 1) // 2
        
        if sum_mid == N:
            return mid
        elif sum_mid < N:
            max_steps = mid
            left = mid + 1
        else:
            right = mid - 1

    return max_steps

def solve():
    import sys
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    results = []

    for i in range(1, T + 1):
        N = int(data[i])
        k = max_stepping_stones(N)
        results.append(k)

    for result in results:
        print(result)

solve()
