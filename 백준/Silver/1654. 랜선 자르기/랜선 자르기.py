def count_lan_cables(lans, length):
    """각 랜선을 length 길이로 잘랐을 때 만들 수 있는 랜선의 개수를 계산"""
    count = 0
    for lan in lans:
        count += lan // length  # 각 랜선에서 몇 개의 랜선을 만들 수 있는지 계산
    return count

def find_max_lan_length(K, N, lans):
    left, right = 1, max(lans)  # 랜선의 길이 범위 (최소 1, 최대는 가장 긴 랜선의 길이)
    result = 0  # 만들 수 있는 최대 랜선의 길이
    
    while left <= right:
        mid = (left + right) // 2  # 중간값을 기준으로 이분 탐색
        if count_lan_cables(lans, mid) >= N:  # N개 이상의 랜선을 만들 수 있으면
            result = mid  # 현재 mid 길이로 N개를 만들 수 있으므로 저장
            left = mid + 1  # 더 긴 랜선 길이를 시도
        else:
            right = mid - 1  # N개를 만들 수 없으면 더 짧은 길이를 시도
    
    return result

# 입력 받기
K, N = map(int, input().split())  # K: 기존 랜선의 개수, N: 필요한 랜선의 개수
lans = [int(input()) for _ in range(K)]  # K개의 랜선의 길이 입력

# 결과 출력
print(find_max_lan_length(K, N, lans))
