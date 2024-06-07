def find_max_height(N, M, tree_heights):
    start = 0
    end = max(tree_heights)
    result = 0

    while start <= end:
        mid = (start + end) // 2
        total = sum(max(0, height - mid) for height in tree_heights)

        if total >= M:
            result = mid
            start = mid + 1
        else:
            end = mid - 1

    return result

# 입력 받기
import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
M = int(data[1])
tree_heights = list(map(int, data[2:]))

# 최대 높이 계산
max_height = find_max_height(N, M, tree_heights)

# 결과 출력
print(max_height)
