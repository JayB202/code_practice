def solution(num_list):
    answer = 0
    sum_num_square = sum(num_list) *sum(num_list)
    mul_num = 1
    for i in num_list:
        mul_num = mul_num*i
    
    
    if sum_num_square > mul_num:
        answer = 1
    return answer