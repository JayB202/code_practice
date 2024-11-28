import sys
from collections import Counter

# 입력 처리
input = sys.stdin.read
data = input().split()
N = int(data[0])
num = list(map(int, data[1:]))

# 산술평균
mean = round(sum(num) / N)  # 소수점 이하 첫째 자리에서 반올림
print(mean)

# 중앙값
num.sort()
median = num[N // 2]
print(median)

# 최빈값
count = Counter(num)  # 등장 횟수 세기
most_common = count.most_common()  # 빈도 내림차순 정렬
max_freq = most_common[0][1]  # 최빈값의 최대 빈도수

# 최빈값 중 두 번째로 작은 값 찾기
modes = [num for num, freq in most_common if freq == max_freq]
modes.sort()  # 여러 최빈값이 있을 경우 정렬
print(modes[1] if len(modes) > 1 else modes[0])

# 최대값과 최소값의 범위
range_value = max(num) - min(num)
print(range_value)