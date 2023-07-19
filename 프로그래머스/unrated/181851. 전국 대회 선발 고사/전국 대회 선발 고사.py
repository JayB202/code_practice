def solution(rank, attendance):
    answer = 0
    attend_list = []
    for i in range(len(attendance)):
        if attendance[i]:
            attend_list.append(rank[i])
    attend_list.sort()
    answer = rank.index(attend_list[0])*10000 + rank.index(attend_list[1])*100 + rank.index(attend_list[2])
            
    return answer