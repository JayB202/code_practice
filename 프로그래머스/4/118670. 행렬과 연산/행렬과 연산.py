from collections import deque

def solution(rc, operations):
    # 행렬의 크기를 구합니다.
    rows = len(rc)
    cols = len(rc[0])
    
    # 각 부분을 deque로 관리
    left_col = deque([rc[i][0] for i in range(rows)])   # 왼쪽 열
    right_col = deque([rc[i][cols - 1] for i in range(rows)])  # 오른쪽 열
    middle_rows = deque([deque(rc[i][1:cols - 1]) for i in range(rows)])  # 중간 부분 (각 행의 가운데 요소들)
    
    # 연산을 순차적으로 처리합니다.
    for operation in operations:
        if operation == "ShiftRow":
            # ShiftRow 연산: 행들을 아래로 한 칸씩 이동
            left_col.rotate(1)
            right_col.rotate(1)
            middle_rows.rotate(1)
        
        elif operation == "Rotate":
            # Rotate 연산: 테두리 요소들을 시계 방향으로 한 칸씩 회전
            # 위쪽 행에서 오른쪽으로 이동
            top = middle_rows[0]
            top.appendleft(left_col.popleft())
            right_col.appendleft(top.pop())
            
            # 오른쪽 열에서 아래로 이동
            bottom = middle_rows[-1]
            bottom.append(right_col.pop())
            
            # 아래쪽 행에서 왼쪽으로 이동
            left_col.append(bottom.popleft())
    
    # 최종 행렬을 구성합니다.
    result = []
    for i in range(rows):
        result.append([left_col[i]] + list(middle_rows[i]) + [right_col[i]])
    
    return result
