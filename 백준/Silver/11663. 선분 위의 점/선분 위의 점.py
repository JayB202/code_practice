import sys
import bisect

def count_points_in_segments(points, segments):
    # 점의 좌표를 정렬
    points.sort()
    
    results = []
    for start, end in segments:
        # 이진 탐색으로 범위 내 점의 개수 계산
        left_index = bisect.bisect_left(points, start)
        right_index = bisect.bisect_right(points, end)
        results.append(right_index - left_index)
    
    return results

# 입력 받기
input = sys.stdin.read
data = input().split()

N = int(data[0])
M = int(data[1])
points = list(map(int, data[2:N+2]))

segments = []
for i in range(N+2, len(data), 2):
    start = int(data[i])
    end = int(data[i+1])
    segments.append((start, end))

# 선분 내 점의 개수 계산
results = count_points_in_segments(points, segments)

# 결과 출력
for result in results:
    print(result)
