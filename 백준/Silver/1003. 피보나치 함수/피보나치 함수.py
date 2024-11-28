#바텀업 

def fibonacci(n):
    if n == 0:
        return (1, 0)  # fibonacci(0) -> 0이 한 번, 1이 한 번
    elif n == 1:
        return (0, 1)  # fibonacci(1) -> 0이 한 번, 1이 한 번

    fib_0 = [0] * (n + 1)  # 0의 횟수
    fib_1 = [0] * (n + 1)  # 1의 횟수
    fib_0[0], fib_1[0] = 1, 0
    fib_0[1], fib_1[1] = 0, 1

    for i in range(2, n + 1):
        fib_0[i] = fib_0[i-1] + fib_0[i-2]
        fib_1[i] = fib_1[i-1] + fib_1[i-2]

    return (fib_0[n], fib_1[n])

T = int(input())  # 테스트 케이스의 수
for _ in range(T):
        N = int(input())  # N번째 피보나치 수
        result = fibonacci(N)
        print(result[0], result[1])
