def min_time_to_finish_immigration(N, M, times):
    left = 1
    right = max(times) * M
    answer = right

    while left <= right:
        mid = (left + right) // 2
        total_people = sum(mid // t for t in times)

        if total_people >= M:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer

# 입력을 받는 부분
import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
M = int(data[1])
times = [int(data[i + 2]) for i in range(N)]

# 최솟값 계산
print(min_time_to_finish_immigration(N, M, times))
