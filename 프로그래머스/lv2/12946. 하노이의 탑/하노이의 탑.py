def solution(n):
    answer = []
    
    def hanoi(n, A, B, C):
        if n == 1:
            answer.append([A,C])
            return                  # n == 1 이면 1-> 3
        hanoi(n-1, A, C, B)         # n != 1 이면 n-1 개를 A-> B, 제일 큰걸 A->C 하는걸 반복
        answer.append([A,C])        # A-> C (제일 큰거)  2^(n-1) 번째에[ 들어가는 [1,3]
        hanoi(n-1, B, A, C)         # B->C 로 보내기 
    
    hanoi(n,1,2,3)
    return answer

    