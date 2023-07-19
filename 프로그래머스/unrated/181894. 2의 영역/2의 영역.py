def solution(arr):
    answer = []
    idxOfTwo= [i for i, value in enumerate(arr) if value == 2]
    if idxOfTwo == []:
        return [-1]
    answer= arr[min(idxOfTwo):max(idxOfTwo)+1]

    return answer