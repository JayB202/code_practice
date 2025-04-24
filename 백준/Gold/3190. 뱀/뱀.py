from collections import deque

# 입력 처리
n = int(input())  # 보드 크기
k = int(input())  # 사과 개수

board = [[0] * n for _ in range(n)]  # 0: 빈칸, 1: 사과

# 사과 위치
for _ in range(k):
    x, y = map(int, input().split())
    board[x - 1][y - 1] = 1  # 인덱스를 0부터 시작하도록 보정

l = int(input())  # 방향 전환 횟수
directions = dict()
for _ in range(l):
    x, c = input().split()
    directions[int(x)] = c

# 초기 설정
dx = [0, 1, 0, -1]  # 동 남 서 북
dy = [1, 0, -1, 0]
direction = 0  # 초기 방향: 동쪽

snake = deque()
snake.append((0, 0))  # 시작 위치
time = 0
x, y = 0, 0  # 뱀 머리 위치

while True:
    time += 1
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 벽 또는 자기자신과 부딪히는 경우
    if not (0 <= nx < n and 0 <= ny < n) or (nx, ny) in snake:
        break

    # 이동
    snake.append((nx, ny))

    if board[nx][ny] == 1:
        board[nx][ny] = 0  # 사과 먹음, 꼬리 그대로
    else:
        snake.popleft()  # 사과 없음, 꼬리 줄이기

    x, y = nx, ny  # 머리 이동

    # 방향 전환이 있는 경우
    if time in directions:
        if directions[time] == 'L':
            direction = (direction - 1) % 4
        else:  # 'D'
            direction = (direction + 1) % 4

print(time)
