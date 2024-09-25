import sys
from collections import deque

# 입력을 빠르게 처리하기 위해 sys.stdin.readline 사용
input = sys.stdin.readline

# 덱 초기화
dq = deque()

# 명령의 수 입력
n = int(input().strip())

# 결과 저장 리스트
result = []

# 명령 처리
for _ in range(n):
    command = input().strip().split()
    
    if command[0] == 'push_front':
        dq.appendleft(int(command[1]))
    elif command[0] == 'push_back':
        dq.append(int(command[1]))
    elif command[0] == 'pop_front':
        if dq:
            result.append(dq.popleft())
        else:
            result.append(-1)
    elif command[0] == 'pop_back':
        if dq:
            result.append(dq.pop())
        else:
            result.append(-1)
    elif command[0] == 'size':
        result.append(len(dq))
    elif command[0] == 'empty':
        if dq:
            result.append(0)
        else:
            result.append(1)
    elif command[0] == 'front':
        if dq:
            result.append(dq[0])
        else:
            result.append(-1)
    elif command[0] == 'back':
        if dq:
            result.append(dq[-1])
        else:
            result.append(-1)

# 결과 출력
sys.stdout.write("\n".join(map(str, result)) + "\n")
