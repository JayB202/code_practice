def find_two_liquids(N, liquid_values):
    # 입력 배열 정렬
    liquid_values.sort()
    
    left = 0
    right = N - 1
    closest_sum = float('inf')
    result = (liquid_values[left], liquid_values[right])
    
    # 두 포인터를 사용하여 최소 합을 찾기
    while left < right:
        current_sum = liquid_values[left] + liquid_values[right]
        
        # 0에 가까운 값을 갱신
        if abs(current_sum) < abs(closest_sum):
            closest_sum = current_sum
            result = (liquid_values[left], liquid_values[right])
        
        # 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로 이동
        if current_sum < 0:
            left += 1
        # 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 이동
        elif current_sum > 0:
            right -= 1
        else:
            # current_sum == 0인 경우, 가장 0에 가까운 값이므로 종료
            break
    
    return result

# 입력 처리
import sys
input = sys.stdin.read
data = input().split()
N = int(data[0])
liquid_values = list(map(int, data[1:]))

# 결과 계산 및 출력
result = find_two_liquids(N, liquid_values)
print(result[0], result[1])
