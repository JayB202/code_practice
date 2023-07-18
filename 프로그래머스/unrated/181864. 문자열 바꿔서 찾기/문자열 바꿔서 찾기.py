def solution(myString, pat):
    answer = 0
    myString = myString.replace("A", "C").replace("B","A").replace("C","B")
    if pat in myString:
        answer = 1
    
    return answer