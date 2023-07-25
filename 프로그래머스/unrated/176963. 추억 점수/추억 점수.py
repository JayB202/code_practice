def solution(name, yearning, photo):
    answer = []
    name_yearning = {name : yearning for name, yearning in zip(name, yearning)}
    
    for idx in range(len(photo)) :
        temp_sum = 0
        for item_2 in photo[idx]:
            if item_2 in name:
                temp_sum += name_yearning[item_2]
        answer.append(temp_sum)
            
    return answer