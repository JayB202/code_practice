def solution(l, r):
    answer = []
    for i in range(l, r+1):
        if all(k in ["0","5"] for k in str(i)):
            answer.append(i)
    
    if answer == []:
        answer.append(-1)
    return answer