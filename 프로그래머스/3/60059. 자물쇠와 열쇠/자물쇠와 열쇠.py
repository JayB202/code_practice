# 입력 :
#       key: 2차원 리스트 ( M x M)
#       lock: 2차원 리스트 (N x N)
# 로직 :  
#       lock를 확장해서 기존 lock를 배치
#           자물쇠의 홈 부분을 찾기 위해 lock 을 확대하고, 패딩 추가
#           확대된 lock 의 가운데 기존 lock 배치
#       키를 회전 시키면서 맞춰보는거
#           key 를 회전 시키는 함수
#           key 가 lock 에 맞는지 확인하는 함수
#               -> 회전 시키면서 lock 맞는지 확인
#                       ->열수 있으면 true
#               -> 안되면 회전 시켜서 다음 방향
#                   -> 최종적으로도 true 안나오면 false
#
# 출력 :
#       자물쇠를 열 수 있으면 true, 없으면 false


def solution(key, lock):
    N = len(lock)
    M = len(key)
    
    # 자물쇠의 홈 부분을 찾기 위해 lock 을 확대하고, 패딩 추가
    expand_lock = [[0] * (N +2 * (M - 1 )) for _ in range(N+2 * (M -1))]
    
    # 확대된 lock 의 가운데 기존 lock 배치
    for i in range(N):
        for j in range(N):
            expand_lock[i+M-1][j+M-1] = lock[i][j]
    
    # key 를 회전 시키는 함수
    def rotate(key):
        return [[key[M-1 -j][i] for j in range(M)] for i in range(M)]
    
    # key 가 lock 에 맞는지 확인하는 함수
    def can_open(x, y , key):
        # 자물쇠 홈 맞춰보며 확인
        temp_lock = [row[:] for row in expand_lock]
        for i in range(M):
            for j in range(M):
                if key[i][j] == 1:
                    if temp_lock[x+i][y+j] == 1:
                        return False
                    temp_lock[x+i][y+j] = 1
        
        # 자물쇠 의 모든 홈이 채워졌는지 확인
        for i in range(N):
            for j in range(N):
                if temp_lock[i+M -1][j+M -1] == 0:
                    return False
                
        return True 
    
    # 키 회전하며 자물 쇠 열수 있는 지 확인
    for rotation in range(4):
        for x in range(N+M - 1):
            for y in range(N+M -1 ):
                if can_open(x,y,key):
                    return True
        key = rotate(key)
        
    return False
