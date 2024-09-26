# 입력
#    첫 번째 줄: 명령의 수 N (1 ≤ N ≤ 10,000)
#    두 번째 줄부터 N개의 줄에 명령어가 주어짐

# 로직 
#    push X: 큐의 뒤쪽에 X를 추가.
#    pop: 큐에서 가장 앞에 있는 정수를 꺼내서 출력. 큐가 비어 있으면 -1 출력.
#    size: 현재 큐의 크기 출력.
#    empty: 큐가 비어있으면 1, 아니면 0 출력.
#    front: 큐의 가장 앞에 있는 값을 출력. 비어있으면 -1 출력.
#    back: 큐의 가장 뒤에 있는 값을 출력. 비어있으면 -1 출력.

# 출력
#    명령에 따른 결과 출력


from collections import deque
import sys

queue = deque()
input = sys.stdin.read
commands = input().splitlines()

N = int(commands[0])

# 명령어 처리
for i in range(1, N + 1):
    command = commands[i]

    if command.startswith("push"):
        _, x = command.split()
        queue.append(int(x))
    elif command == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif command == "size":
        print(len(queue))
    elif command == "empty":
        print(1 if not queue else 0)
    elif command == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif command == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
