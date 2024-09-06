#1. 입력 :    N = 총 보석의 수, K = 상덕이가 가진 가방의 수, 
#            Mi  = 보석의 무게, Vi = 보석의 가격, 
#            Ci = 가방에 담을수 있는 최대 무게

#2. 문제풀이 로직
#2-1.        보석 리스트를 무게 순으로 정렬
#2-2.        가방 리스트를 무게 순으로 정렬
#2-3.        각 가방에 넣을수 있는 보석을 선택 -> 제일 비싼 보석 선택
#2-4.        각 가방에 들어간 보석들의 값을 더함

#3 .출력 : 훔칠수 있는 보석의 최대 가격의 합
import heapq

def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    # 첫 줄에서 N과 K를 추출
    N, K = map(int, data[0].split())

    # 보석 리스트 (무게, 가격)
    jewels = []
    for i in range(1, N + 1):
        weight, value = map(int, data[i].split())
        jewels.append((weight, value))

    # 가방 리스트
    bags = []
    for i in range(N + 1, N + K + 1):
        bags.append(int(data[i]))

    # 보석 리스트를 무게 기준으로 정렬 (오름차순)
    jewels.sort(key=lambda x: x[0])

    # 가방 리스트를 무게 기준으로 정렬 (오름차순)
    bags.sort()

    # 최대 힙 (heapq는 최소힙이므로 음수를 사용하여 최대힙처럼 사용)
    max_heap = []
    
    max_total_value = 0
    jewel_idx = 0

    # 각 가방에 대해 적절한 보석을 선택
    for bag_weight in bags:
        # 현재 가방에 담을 수 있는 보석들을 힙에 추가
        while jewel_idx < N and jewels[jewel_idx][0] <= bag_weight:
            heapq.heappush(max_heap, -jewels[jewel_idx][1])  # 음수를 넣어서 최대 힙처럼 사용
            jewel_idx += 1

        # 힙에서 가장 비싼 보석을 선택
        if max_heap:
            max_total_value += -heapq.heappop(max_heap)  # 다시 양수로 변환하여 사용

    # 결과 출력
    print(max_total_value)

if __name__ == "__main__":
    main()
