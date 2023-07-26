def solution(n, m, section):
    answer = 0
    k= 0
    for i in section : 
        if k >i :
            continue
        answer += 1
        k = i+ m
    return answer