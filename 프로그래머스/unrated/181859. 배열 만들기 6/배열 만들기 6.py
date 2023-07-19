def solution(arr):
    answer = []
    i = 0
    while i <len(arr):
        if answer == []:
            answer.append(arr[i])
            i += 1
        elif answer != [] and answer[-1] == arr[i]:
            answer.pop()
            i += 1
        elif answer !=[] and answer[-1] != arr[i]:
            answer.append(arr[i])
            i += 1
            
    if answer == []:
        return [-1]
    return answer