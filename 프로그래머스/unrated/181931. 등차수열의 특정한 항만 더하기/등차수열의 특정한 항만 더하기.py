def solution(a, d, included):
    answer = 0
    count = 0
    d_count= 0
    for i in range(len(included)) :
        if included[i] == True :
            count += 1
            d_count += i
    answer  = count * a + d *d_count
    
            
    return answer