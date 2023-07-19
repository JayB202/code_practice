def solution(my_string):
    answer = []
    answer = my_string.split(" ")
    while ("" in answer):
        answer.remove("")
    return answer