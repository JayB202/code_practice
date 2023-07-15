def solution(arr, k):
    answer = []
    if k %2 == 0:
        answer = [n+k for n in arr]
    else:
        answer = [n*k for n in arr]
    return answer