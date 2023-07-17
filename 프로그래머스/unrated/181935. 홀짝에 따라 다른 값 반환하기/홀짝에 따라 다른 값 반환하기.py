def solution(n):
    answer = 0
    for i in range(n+1):
        if (n %2 == 0) and (i%2==0):
            answer += i**2
        elif(n%2==1) and (i%2==1):
            answer += i
    return answer