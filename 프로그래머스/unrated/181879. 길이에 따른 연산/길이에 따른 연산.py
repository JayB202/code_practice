def solution(num_list):
    answer = 0
    if len(num_list) > 10 :
        answer = sum(num_list)
    else:
        answer = 1 
        for num in num_list:
            answer = answer * num
    return answer