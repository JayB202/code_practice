def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report = set(report)
    reported = {x: 0 for x in id_list}
    
    for r in report:
        user, target = r.split(' ')
        reported[target] += 1
    
    for r in report :
        user, target = r.split(' ')
        if reported[target] >= k:
            answer[id_list.index(user)] += 1
    
    return answer