def solution(str_list):
    answer = []
    if "l" not in str_list and "r" not in str_list:
        return []
    
    for i in str_list:
        if i == "r":
            answer = str_list[str_list.index(i)+1:]
            break
        elif i == "l":
            answer = str_list[:str_list.index(i)]
            break
        
    return answer