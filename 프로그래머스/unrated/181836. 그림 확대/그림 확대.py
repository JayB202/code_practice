def solution(picture, k):
    answer = []
    ans = ''
    for i in range(len(picture)):
        for t in range(len(picture[i])):
            ans += picture[i][t]*k
        
        for j in range(k):
            answer.append(ans)
        ans = ''
    return answer