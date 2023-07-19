def solution(myString):
    answer = ''
    for c in myString:
        if c <= "l":
            answer += "l"
        else:
            answer += c
    return answer