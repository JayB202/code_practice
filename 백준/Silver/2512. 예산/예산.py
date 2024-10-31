# 입력 : 첫번째 줄 - 지방의 수 N, 두번째 줄 - 예산 요청 리스트, 세번째 줄 - 총 예산 M 

# 로직  : 모든 요청 금액이 M 이하인 경우 -> 요청 금액 그대로 배정
#      : 예산 초과할 경우 -> 특정 상한액을 설정, 각 요청이 상한액 이하로 제한되도록 ( 정수)
#            -> 각 요청 금액과 상한액을 비교

# 출력 : 상한액 출력

def find_max_budget(requests, total_budget):
    left, right = 0, max(requests)
    answer = 0
    
    while left <= right:
        mid = (left + right) // 2
        allocated = sum(min(request, mid) for request in requests)
        
        if allocated <= total_budget:
            answer = mid  # 가능한 최대 상한액을 업데이트
            left = mid + 1
        else:
            right = mid - 1

    return answer


n = int(input())
requests = list(map(int, input().split()))
total_budget = int(input())


print(find_max_budget(requests, total_budget))
