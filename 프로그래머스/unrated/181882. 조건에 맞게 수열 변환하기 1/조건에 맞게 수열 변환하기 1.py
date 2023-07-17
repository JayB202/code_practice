def solution(arr):
    answer = []
    for i in arr :
        if (i >= 50) & (i%2 == 0):
            i = i//2
        elif (i < 50) & (i%2 == 1):
            i = i*2
        answer.append(i)
    return answer