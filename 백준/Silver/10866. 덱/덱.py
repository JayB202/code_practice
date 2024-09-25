# 입력 : 첫째 줄에 주어지는 명령의 수 N, . 둘째 줄부터 N개의 줄에는 명령이 하나씩
#
# 로직 
# push_front X: 정수 X를 덱의 앞에 넣는다.
# push_back X: 정수 X를 덱의 뒤에 넣는다.
# pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# size: 덱에 들어있는 정수의 개수를 출력한다.
# empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
# front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
#
#
# 출력 : 한줄에 하나씩 명령 결과 출력 

import sys
from collections import deque

input = sys.stdin.readline

dq = deque()
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

sys.stdout.write("\n".join(map(str, result)) + "\n")
