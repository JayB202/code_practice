def solution(strArr):
    answer = []
    for string in strArr:
        if "ad" not in string:
            answer.append(string)
    return answer