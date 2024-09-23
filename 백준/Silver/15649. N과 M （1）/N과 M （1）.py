def backtrack(N, M, sequence, visited):
    # 길이가 M인 수열을 완성한 경우 출력
    if len(sequence) == M:
        print(' '.join(map(str, sequence)))
        return
    
    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            sequence.append(i)
            backtrack(N, M, sequence, visited)  # 재귀 호출
            sequence.pop()  # 마지막 숫자를 제거하고 돌아감
            visited[i] = False

def solve(N, M):
    visited = [False] * (N + 1)  # 방문 여부를 저장하는 리스트
    backtrack(N, M, [], visited)

# 입력 받기
N, M = map(int, input().split())
solve(N, M)