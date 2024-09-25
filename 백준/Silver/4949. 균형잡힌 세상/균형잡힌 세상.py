# 입력 문자열 리스트
input_strings = []
while True:
    input_str = input()  # 입력 문자열
    if input_str == '.':  # 입력 종료 조건
        break
    input_strings.append(input_str)

for input_str in input_strings:
    check = []  # 괄호를 체크하기 위한 리스트
    answer = 'yes'  # 기본 답변은 'yes'

    for s in input_str:
        if s == '(' or s == '[':  # 열린 괄호가 들어오면 체크 리스트에 추가
            check.append(s)
        elif s == ')':  # 닫힌 소괄호 처리
            if not check or check.pop() != '(':  # 열린 괄호가 없거나 잘못된 짝인 경우
                answer = 'no'
                break
        elif s == ']':  # 닫힌 대괄호 처리
            if not check or check.pop() != '[':  # 열린 괄호가 없거나 잘못된 짝인 경우
                answer = 'no'
                break

    if len(check) > 0:  # 괄호 검사가 끝난 후에도 리스트에 괄호가 남아있는 경우
        answer = 'no'
        
    print(answer)  # 결과 출력
