#입력
#   [[의상이름, 의상 종류], ]      # 2차원 배열
#로직
#   종류별로 1가지만 착용 가능 -> 종류별 그룹화
#   조합 계산 (안 입은 경우도 있으니, 종류별 선택가능 수 + 1 )
#   전체 조합수 계산   -> 아무것도 입지 않은 경우 제외 ( answer -= 1)



#출력

def solution(clothes):
    answer = 1
    cloth_type_count= {}
    for cloth, cloth_type in clothes :
            cloth_type_count[cloth_type] = cloth_type_count.get(cloth_type,0) +1
    
    for cloth_type in cloth_type_count :
        answer *= (cloth_type_count[cloth_type] +1)
    answer -= 1
    return answer