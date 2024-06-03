import itertools

# 다섯 줄의 입력을 받는다
words = [input().strip() for _ in range(5)]

# zip_longest를 사용하여 세로로 읽기
result = []
for chars in itertools.zip_longest(*words, fillvalue=None):
    for char in chars:
        if char is not None:
            result.append(char)

# 리스트를 문자열로 변환하여 출력
print("".join(result))