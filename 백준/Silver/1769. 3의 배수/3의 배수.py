def schedules(s):
    return sum(map(int, s))

# 변수 선언
count, X = 0, input().strip()

# 합계 값 리턴 받기
total = schedules(X)
count += 1

if total < 10 : 
    if total % 3 == 0: 
        print(0, "YES", sep="\n")
    else: 
        print(0, "NO", sep="\n")
else:        
    # 한 자리 수가 될 때까지 반복
    while total >= 10:  # 수정: total이 10 이상인 동안 반복
        total = schedules(str(total))
        count += 1

    # 3의 배수 판단
    if total == 0 or total % 3 == 0: 
        print(count, "YES", sep="\n")
    else: 
        print(count, "NO", sep="\n")
