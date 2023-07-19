def solution(myString, pat):
    answer = myString.rsplit(pat,1)[0]+pat
    
    return answer