import heapq

n = int(input().rstrip())
max_heap = []

for _ in range(n):
    nums = list(map(int, input().rstrip().split()))
    presentNum = nums[0] # 선물의 개수 변수로 담아줌
  
    if presentNum == 0: # 선물의 개수가 0일 때
        try: 
            print(-heapq.heappop(max_heap)) # heap의 최대값 출력
        except: 
            print(-1) # heap의 요소가 없을 경우 -1 출력
    else:
        for num in nums[1:]:  # 첫 번째 요소를 제외한 나머지를 선물 추가
            heapq.heappush(max_heap, -num)  # 변환된 리스트 heap으로 변환            