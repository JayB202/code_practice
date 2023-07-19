def solution(n):
    if n == 1:
        return [[1]]
    answer = [[0 for j in range(n)] for i in range(n)]
    value = 1
    x, y = 0, 0
    direction = "right"
    for i in range(n*n):
        answer[x][y] += value
        value += 1
        if direction =="right":
            y += 1
            if y == n-1 or answer[x][y+1] != 0:
                direction ="down"
        elif direction == "down":
            x += 1
            if x == n-1 or answer[x+1][y] != 0:
                direction = "left"
        elif direction =="left":
            y -= 1
            if y == 0 or answer[x][y-1] != 0:
                direction = "up"
        elif direction =="up":
            x -= 1
            if x == 0 or answer[x-1][y] != 0:
                direction = "right"
        
    return answer