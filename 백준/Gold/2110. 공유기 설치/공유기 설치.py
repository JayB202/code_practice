def can_place_routers(houses, C, distance):
    count = 1  # 첫 번째 공유기는 무조건 설치
    last_position = houses[0]  # 첫 번째 집에 공유기 설치
    
    for i in range(1, len(houses)):
        if houses[i] - last_position >= distance:
            count += 1
            last_position = houses[i]
        if count >= C:
            return True
    return False

def max_min_distance(houses, C):
    houses.sort()
    
    left = 1  # 가능한 최소 거리
    right = houses[-1] - houses[0]  # 가능한 최대 거리
    best_distance = 0
    
    while left <= right:
        mid = (left + right) // 2
        
        if can_place_routers(houses, C, mid):
            best_distance = mid
            left = mid + 1
        else:
            right = mid - 1
    
    return best_distance

# 입력 처리
import sys
input = sys.stdin.read
data = input().split()
N = int(data[0])
C = int(data[1])
houses = [int(data[i+2]) for i in range(N)]

# 결과 계산 및 출력
print(max_min_distance(houses, C))
