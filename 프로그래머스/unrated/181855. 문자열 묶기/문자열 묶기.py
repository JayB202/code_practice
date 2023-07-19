def solution(strArr):
    answer = 0
    ans_list = [0]*31
    for i in strArr:
        ans_list[len(i)] += 1
    answer = max(ans_list)
    return answer