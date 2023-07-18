def solution(str_list, ex):
    answer = ''
    for str_fact in str_list:
        if ex not in str_fact:
            answer += str_fact            
    return answer