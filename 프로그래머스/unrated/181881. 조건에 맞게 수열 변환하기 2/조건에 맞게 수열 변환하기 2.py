def solution(arr):
    answer = 0
    preArray = arr
    while True:
        newArray = []
        for i in preArray:
            if i >= 50 and i%2 == 0:
                newArray.append(i//2) 
            elif i< 50 and i%2 == 1:
                newArray.append(i*2 +1)
            else:
                newArray.append(i)
        if newArray == preArray:
            break
        answer += 1
        preArray = newArray
    return answer