# 입력:
#   key: 키의 2차원 리스트 (크기M×M)
#   lock: 자물쇠의 2차원 리스트 (크기 N×N)
# 로직:
#   자물쇠를 확장하여 중앙에 기존 자물쇠를 배치
#   키를 회전시키며 맞춰봄
#   자물쇠가 열리는지 확인하고, 열릴 수 있으면 True
#   모든 위치와 회전을 시도해도 열리지 않으면 False
#출력:
#   자물쇠를 열 수 있으면 True, 열 수 없으면 False


def solution(key, lock):
    N = len(lock)
    M = len(key)
    
    # 자물쇠의 홈 부분을 찾기 위해 lock을 확대하여 패딩을 추가
    expanded_lock = [[0] * (N + 2 * (M - 1)) for _ in range(N + 2 * (M - 1))]
    
    # 확대된 lock의 가운데에 기존 lock을 배치
    for i in range(N):
        for j in range(N):
            expanded_lock[i + M - 1][j + M - 1] = lock[i][j]
    
    # key를 회전시키는 함수
    def rotate(key):
        return [[key[M - 1 - j][i] for j in range(M)] for i in range(M)]
    
    # key가 lock에 맞는지 확인하는 함수
    def can_open(x, y, key):
        # 자물쇠의 홈 부분에 key를 맞추어 보며 확인
        temp_lock = [row[:] for row in expanded_lock]
        for i in range(M):
            for j in range(M):
                if key[i][j] == 1:
                    if temp_lock[x + i][y + j] == 1:
                        return False
                    temp_lock[x + i][y + j] = 1
        # 자물쇠의 모든 홈이 채워졌는지 확인
        for i in range(N):
            for j in range(N):
                if temp_lock[i + M - 1][j + M - 1] == 0:
                    return False
        return True
    
    # key를 회전하면서 이동시키며 자물쇠를 열 수 있는지 확인
    for rotation in range(4):
        for x in range(N + M - 1):
            for y in range(N + M - 1):
                if can_open(x, y, key):
                    return True
        key = rotate(key)
    
    return False
