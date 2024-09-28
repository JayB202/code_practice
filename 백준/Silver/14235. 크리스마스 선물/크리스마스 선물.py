import heapq

n = int(input().rstrip())
max_heap = []  # max_heap을 루프 밖에서 초기화

for _ in range(n):
    nums = list(map(int, input().rstrip().split()))
    presentNum = nums.pop(0)  # 선물의 개수 변수로 담아줌 (첫 번째 요소)

    if presentNum == 0:  # 선물의 개수가 0일 때
        if max_heap:  # 힙이 비어 있지 않은 경우
            print(-heapq.heappop(max_heap))  # 최대값 출력
        else:
            print(-1)  # 힙이 비어 있을 경우 -1 출력
    else:
        for num in nums:  # 선물 추가
            heapq.heappush(max_heap, -num)  # 음수로 추가하여 최대 힙처럼 사용
