def solution(strArr):
    answer = 0
    ans_dic = dict()
    for x in range(31):
         ans_dic[x]= 0
    for i in strArr:
         ans_dic[len(i)] = ans_dic[len(i)] +1
    
    answer = ans_dic[max(ans_dic, key=ans_dic.get)]
    return answer