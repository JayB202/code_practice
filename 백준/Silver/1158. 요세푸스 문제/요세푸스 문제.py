from collections import deque

def josephus(N, K):
    # 1부터 N까지 사람들 리스트 생성
    people = deque(range(1, N+1))
    result = []

    # 큐를 이용해 K번째 사람 제거
    while people:
        # K-1번 왼쪽으로 회전(K번째 사람을 앞으로 가져옴)
        people.rotate(-(K-1))
        # 맨 앞 사람 제거하고 결과 리스트에 추가
        result.append(people.popleft())

    # 결과 출력 형식
    print("<" + ", ".join(map(str, result)) + ">")

# 입력 받기
N, K = map(int, input().split())
josephus(N, K)
