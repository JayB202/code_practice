def solution(start, end):
    answer = [n for n in range(end, start+1)]
    answer.sort(reverse = True)
    return answer