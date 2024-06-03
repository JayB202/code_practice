# 입력받기
N = int(input())
room = [input().strip() for _ in range(N)]

# 가로로 누울 수 있는 자리 수 세기
horizontal_count = 0
for row in room:
    empty_spaces = row.split('X')
    for space in empty_spaces:
        if len(space) >= 2:
            horizontal_count += 1

# 세로로 누울 수 있는 자리 수 세기
vertical_count = 0
for col in range(N):
    column = ''.join(room[row][col] for row in range(N))
    empty_spaces = column.split('X')
    for space in empty_spaces:
        if len(space) >= 2:
            vertical_count += 1

# 결과 출력
print(horizontal_count, vertical_count)