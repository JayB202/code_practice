from itertools import combinations
from math import gcd

def lcm(a, b):
    return a * b // gcd(a, b)

def lcm_three(a, b, c):
    return lcm(lcm(a, b), c)

# 입력 받기
numbers = list(map(int, input().split()))

# 가능한 모든 세 개의 조합 생성
combs = list(combinations(numbers, 3))

# 모든 조합의 LCM을 계산하고 최소값 찾기
min_lcm = float('inf')
for comb in combs:
    current_lcm = lcm_three(comb[0], comb[1], comb[2])
    if current_lcm < min_lcm:
        min_lcm = current_lcm

print(min_lcm)
