def compute_hash(length, string):
    r = 31
    M = 1234567891
    hash_value = 0

    for i in range(length):
        # 알파벳 a~z를 1~26으로 변환
        a_i = ord(string[i]) - ord('a') + 1
        # 해시 값 계산
        hash_value = (hash_value + a_i * pow(r, i, M)) % M
    
    return hash_value

def main():
    # 입력
    L = int(input().strip())
    string = input().strip()

    # 해시 값 계산
    result = compute_hash(L, string)
    
    # 결과 출력
    print(result)

if __name__ == "__main__":
    main()
