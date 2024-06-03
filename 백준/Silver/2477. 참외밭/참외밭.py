
from sys import stdin
from collections import deque

# 4가지 패턴 중 어떤 패턴인지 찾기
# 무작위 꼭짓점에서 시작하기 때문에 패턴을 찾으면서 lengths 배열도 돌리기
def getSize(map):
    PATTERNS = ["231314", "231414", "231424", "232314"]
    pattern = deque()
    lengths = deque()

    # 주어진 map 데이터를 pattern과 lengths로 분리하여 저장
    for vector, length in map:
        pattern.append(vector)
        lengths.append(int(length))

    patternType = None
    # 패턴을 회전시키며 PATTERNS에 있는지 확인
    for _ in range(len(pattern)):
        target = ''.join(list(pattern))
        if target in PATTERNS:
            patternType = PATTERNS.index(target)
            break
        pattern.append(pattern.popleft())
        lengths.append(lengths.popleft())

    # 패턴 유형에 따라 넓이를 계산하여 반환
    return calcSize(lengths, patternType)

# 길이와 패턴을 입력하면 정해진 규칙에 맞춰 넓이 계산
def calcSize(lengths, pattern):
    if pattern == 0:
        return lengths[0] * lengths[5] - lengths[2] * lengths[3]
    elif pattern == 1:
        return lengths[0] * lengths[1] - lengths[3] * lengths[4]
    elif pattern == 2:
        return lengths[1] * lengths[2] - lengths[4] * lengths[5]
    elif pattern == 3:
        return lengths[4] * lengths[5] - lengths[1] * lengths[2]

def main(n, map):
    size = getSize(map)
    print(n * size)

n = int(stdin.readline())
map = [stdin.readline().strip().split() for _ in range(6)]
main(n, map)