def solution(distance, rocks, n):
    # 바위 위치를 정렬
    rocks.sort()
    
    left = 1  # 가능한 거리의 최소값
    right = distance  # 가능한 거리의 최대값
    answer = 0

    # 이진 탐색 시작
    while left <= right:
        mid = (left + right) // 2  # 중간 값 설정
        removed_rocks = 0  # 제거된 바위의 수
        prev = 0  # 이전 위치 초기화 (출발지점)

        # 각 바위를 순회하며 거리 계산
        for rock in rocks:
            # 현재 바위와 이전 위치 사이의 거리가 mid보다 작으면 제거
            if rock - prev < mid:
                removed_rocks += 1
            else:
                # 그렇지 않으면 이전 위치 갱신
                prev = rock

        # 도착지점과 마지막 바위 사이의 거리 체크
        if distance - prev < mid:
            removed_rocks += 1

        # 제거된 바위의 수가 n보다 크면, mid를 줄여야 함
        if removed_rocks > n:
            right = mid - 1
        else:
            # 제거된 바위의 수가 n 이하이면, 가능한 거리의 최댓값 갱신
            answer = mid
            left = mid + 1

    return answer
