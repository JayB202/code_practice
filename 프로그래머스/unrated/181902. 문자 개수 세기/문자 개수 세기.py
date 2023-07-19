def solution(my_string):
    answer = [0]*52
    for string in my_string:
        if string.isupper():
            ascii_value = 65
        else:
            ascii_value = 71
        answer[ord(string)-ascii_value] += 1
    return answer