def solution(code):
    answer = ''
    mode = 1
    for i in range(len(code)) :
        if code[i] == "1":
            mode *= (-1)
        elif mode == 1:
            if i % 2 == 0:
                answer += code[i]    
        else:
            if i%2 == 1:
                answer += code[i]
    if answer == "":
        answer = "EMPTY"
        
    return answer