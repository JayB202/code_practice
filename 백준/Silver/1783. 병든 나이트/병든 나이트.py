def sick_knight(N, M):
    if N == 1: 
            return 1
    elif N == 2:
        return min(4, (M+1)//2)
    elif M < 7 :
        return min(4,M)
    else:
        return M -2 
    

    
N, M = map(int, input().split())
print(sick_knight(N,M))