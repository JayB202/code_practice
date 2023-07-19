def solution(arr, intervals):
    answer = []
    for i, k in intervals:
        answer += arr[i:k+1] 
    return answer