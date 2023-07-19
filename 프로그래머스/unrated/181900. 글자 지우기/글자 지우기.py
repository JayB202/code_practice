def solution(my_string, indices):
    answer = ''
    my_list = list(my_string)
    for idx in range(len(my_list)):
        if idx not in indices:
            answer += my_list[idx]
    return answer