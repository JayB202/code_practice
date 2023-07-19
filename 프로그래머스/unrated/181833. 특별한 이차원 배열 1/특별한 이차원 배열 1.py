def solution(n):
    answer = []
    n_list = [ 1] +[ 0 for i in range(1, n)]
    for i in range(0, n):
        answer.append(n_list[i:]+n_list[:i])
    answer.sort(reverse=True)
    return answer