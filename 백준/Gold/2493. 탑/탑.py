def find_receiving_towers(n, heights):
    stack = []  # (index, height)를 저장하는 스택
    result = [0] * n  # 결과를 저장할 리스트

    for i in range(n):
        while stack and stack[-1][1] < heights[i]:
            stack.pop()  # 현재 탑보다 낮은 탑은 제거

        if stack:
            result[i] = stack[-1][0] + 1  # 스택의 top에 있는 탑이 신호를 받음 (1-based index)
        else:
            result[i] = 0  # 수신하는 탑이 없으면 0

        stack.append((i, heights[i]))  # 현재 탑을 스택에 추가

    return result


n = int(input())
heights = list(map(int, input().split()))


print(*find_receiving_towers(n, heights))