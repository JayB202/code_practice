def find_smallest_ticket(N, sold_tickets):
    # 이미 팔린 티켓 번호를 집합에 저장
    sold_set = set(sold_tickets)

    # 1번 티켓부터 시작해서 가장 작은 팔리지 않은 티켓 번호 찾기
    current_ticket = 1
    while current_ticket in sold_set:
        current_ticket += 1

    return current_ticket

# 입력 받기
import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
sold_tickets = list(map(int, data[1:]))

# 결과 출력
print(find_smallest_ticket(N, sold_tickets))
