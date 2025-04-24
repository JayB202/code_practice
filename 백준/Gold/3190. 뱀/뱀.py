# 입력 :  n = 보드크기 
#        k = 사과개수
#        다음 k 줄 : 사과 위치
#        l = 방향변환 횟수
#        다음 l 줄 : 방향 변환 정보

# 조건 : 
#        1. 머리 위치 이동
#        2. 머리가 벽이나 자신과 부딪히면 게임 종료
#        3-1. 이동한 칸에 사과 있으면 사과가 없어지고 꼬리 움직임 x ( 한칸 추가)
#        3-2.           사과 없으면 꼬리 이동 
#        4. 방향 변환 정보 확인
#        끝날때가지 위 과정 반복
#         시작 방향? (1,1) 에서 오른쪽 
#                 -> 왼쪽으로이동? // 상
#                 -> 오른쪽 이동? // 하
#                    우 하 좌 상 로 하면 인덱스 +- 1 해서 해결 가능 

# 출력 : 게임이 몇초에 끝나는지 출력



import sys
from collections import deque

input = sys.stdin.readline

# 1. 보드 크기 및 초기화
n = int(input())  # 보드 크기
board = [[0] * n for _ in range(n)]  # 0: 빈 칸, 1: 사과

# 2. 사과 위치 입력받고 보드에 표시
k = int(input())
for _ in range(k):
    x, y = map(int, input().split())
    board[x - 1][y - 1] = 1  # 1-based → 0-based 인덱스로 변환

# 3. 방향 전환 정보 저장
l = int(input())
directions = dict()
for _ in range(l):
    x, c = input().split()
    directions[int(x)] = c  # 시간: 방향('L' 또는 'D')

# 4. 방향 정보 (동, 남, 서, 북 순)
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
direction = 0  # 시작 방향: 오른쪽(동)

# 5. 뱀의 상태를 deque로 관리 (꼬리: 앞, 머리: 뒤)
snake = deque()
snake.append((0, 0))  # 시작 위치

# 6. 초기 시간 및 머리 위치
time = 0
x, y = 0, 0

# 7. 게임 시작 (매 초마다 반복)
while True:
    time += 1  # 시간 1초 경과

    # 1) 머리 이동 (다음 위치 계산)
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 2) 벽이나 자기자신과 충돌 시 게임 종료
    if not (0 <= nx < n and 0 <= ny < n) or (nx, ny) in snake:
        break

    # 3) 뱀의 머리 이동
    snake.append((nx, ny))

    if board[nx][ny] == 1:
        board[nx][ny] = 0  # 사과 먹기 (꼬리 그대로)
    else:
        snake.popleft()  # 사과 없음 → 꼬리 이동 (길이 유지)

    # 4) 머리 위치 갱신
    x, y = nx, ny

    # 5) 방향 전환 정보가 있는 시간인지 확인
    if time in directions:
        if directions[time] == 'L':
            direction = (direction - 1) % 4  # 왼쪽 회전
        else:  # 'D'
            direction = (direction + 1) % 4  # 오른쪽 회전

# 8. 게임이 종료된 시간 출력
print(time)
