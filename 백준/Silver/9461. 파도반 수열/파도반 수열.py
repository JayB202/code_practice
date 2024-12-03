def memoize(f):
    memo = {}
    def helper(n):
        if n not in memo:
            memo[n] = f(n)
        return memo[n]
    return helper

@memoize
def P(N):
    if N == 1 or N == 2 or N == 3:
        return 1
    return P(N-2) + P(N-3)

def solve():
    T = int(input())
    for _ in range(T):
        N = int(input())
        print(P(N))

solve()
