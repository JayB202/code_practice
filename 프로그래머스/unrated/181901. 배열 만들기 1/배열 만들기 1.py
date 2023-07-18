def solution(n, k):
    answer = []
    t= 1
    while( t <= n//k):
        answer.append(k *t)
        t += 1
    return answer