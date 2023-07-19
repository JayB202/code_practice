def solution(arr):
    answer = [[]]
    if len(arr) > len(arr[0]):
        for i in arr :
            for k in range(len(arr)-len(arr[-1])):
                i.append(0)
    elif len(arr)<len(arr[0]):
        for k in range(len(arr[0])-len(arr)):
            arr.append([0]*len(arr[0]))
    
    
    answer = arr    
            
    return answer