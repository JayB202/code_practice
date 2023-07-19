def solution(order):
    answer = sum([4500 if 'an' in x else 5000 for x in order])
    return answer