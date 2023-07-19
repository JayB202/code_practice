def solution(myStr):
    answer = []
    newStr = ""
    for idx in range(len(myStr)):
        if myStr[idx] not in ["a","b","c"] :
            newStr += myStr[idx]
        else:
            if newStr != "":
                answer.append(newStr)
            newStr = ""
    answer.append(newStr)
    while "" in answer:
        answer.remove("")
            
    
    if answer == []:
        answer.append("EMPTY")
    return answer