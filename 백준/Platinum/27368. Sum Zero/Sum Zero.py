def find_max_zero_subarrays(c, L, R):
    # 부분 배열의 누적 합을 계산하고 이를 저장
    prefix_sum = [0] * (len(c) + 1)
    for i in range(1, len(c) + 1):
        prefix_sum[i] = prefix_sum[i - 1] + c[i - 1]
    
    # 결과를 저장할 리스트
    results = []

    # 각 쿼리에 대해 처리
    for l, r in zip(L, R):
        l -= 1  # 0-based index로 변환
        r -= 1  # 0-based index로 변환
        subarray_sums = {}
        count = 0
        current_sum = 0

        for i in range(l, r + 1):
            current_sum += c[i]
            if current_sum == 0:
                count += 1
                current_sum = 0
                subarray_sums.clear()
            elif current_sum in subarray_sums:
                count += 1
                current_sum = 0
                subarray_sums.clear()
            else:
                subarray_sums[current_sum] = i

        results.append(count)
    
    return results

# 입력 받기
N = int(input().strip())
c = list(map(int, input().strip().split()))
Q = int(input().strip())
queries = [tuple(map(int, input().strip().split())) for _ in range(Q)]

# 쿼리 결과 출력
results = find_max_zero_subarrays(c, [q[0] for q in queries], [q[1] for q in queries])
for result in results:
    print(result)