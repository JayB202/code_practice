def solution(my_string):
    answer = []
    for i in range(0,len(my_string)+1):
        answer.append(my_string[-i:])
    answer = list(set(answer))
    answer.sort()
    return answer