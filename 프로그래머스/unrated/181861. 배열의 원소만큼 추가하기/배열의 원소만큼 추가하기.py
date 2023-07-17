def solution(arr):
    answer = []
    for num in arr :
        for time in range(num):
            answer.append(num)
    return answer