#입력
#    첫줄 테스트 케이스 T ( T <= 100),
#    그다음 3줄에 단위로, 첫줄  N, M   세준 세비 병사수, 두번째줄 세준병사힘 , 세번째줄 세비 병사힘
#로직
#   세준과 세비의 병사들의 힘 비교 -> 최소값 찾아서 제거 ( 정렬 해두면 될듯)  인데 결국 최대값 비교
#   세준이 병사들의 최대힘이 세비 병사으 ㅣ최대힘보다 크면 세준이 승리-> 반대면 세비가 승리
#   최대값이 같으면 무승부
#출력
#    세준이가 이기면 S , 세비가 이기면 B 둘다 아니면 C



T = int(input())  
    

def game_result(n, m, sejun, sebi):
    while sejun and sebi:
        if sejun[-1] >= sebi[-1] : 
            sebi.pop()
        else :
            sejun.pop()
    if sejun :
        return "S"
    if sebi :
        return "B"
    return "C"

results = []
 
for _ in range(T):
    input()
    # 각 테스트 케이스 입력 받기
    n, m = map(int, input().split())  # N, M 입력
    sejun = sorted(list(map(int, input().split())), reverse = True)  # 세준이 병사들 힘 리스트
    sebi = sorted(list(map(int, input().split())), reverse = True)   # 세비 병사들 힘 리스트
        
    # 결과 계산
    result = game_result(n, m, sejun, sebi)
    results.append(result)
    
    
for result in results:
        print(result)