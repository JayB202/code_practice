def fashion_combination_count(test_cases):
    results = []

    for case in test_cases:
        n, clothes = case
        if n == 0:
            results.append(0)
            continue

        # 의상의 종류별로 개수를 세기 위한 딕셔너리
        clothing_dict = {}
        for name, type in clothes:
            if type in clothing_dict:
                clothing_dict[type] += 1
            else:
                clothing_dict[type] = 1

        # 조합의 수를 계산
        combinations = 1
        for count in clothing_dict.values():
            combinations *= (count + 1)

        # 알몸인 경우(모든 의상을 입지 않는 경우)를 제외하기 위해 1을 뺌
        results.append(combinations - 1)

    return results

def parse_input():
    import sys
    input = sys.stdin.read
    data = input().strip().split('\n')

    index = 0
    num_cases = int(data[index])
    index += 1

    test_cases = []
    for _ in range(num_cases):
        n = int(data[index])
        index += 1
        clothes = []
        for _ in range(n):
            name, type = data[index].split()
            clothes.append((name, type))
            index += 1
        test_cases.append((n, clothes))
    
    return test_cases


test_cases = parse_input()

results = fashion_combination_count(test_cases)
for result in results:
    print(result)
