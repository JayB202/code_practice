def solution(arr, queries):
    answer = []
    cor_list = []
    for query in queries :
        for i in range(query[0], query[1]+1):
            if arr[i] > query[2] :
                cor_list.append(arr[i])  
        if cor_list == []:
            answer.append(-1)
        else:
            answer.append(min(cor_list))            
        cor_list=[]
    return answer