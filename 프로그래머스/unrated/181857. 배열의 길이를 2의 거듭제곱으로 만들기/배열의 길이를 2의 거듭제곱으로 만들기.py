def solution(arr):
    answer = arr
    length = len(arr)
    count = 0
    while length != 1:
        length = length//2 
        count += 1
    if (2**count) == len(arr) :
        return answer
    else:
        for i in range(2**(count+1) - len(arr)):
            answer.append(0)
    return answer