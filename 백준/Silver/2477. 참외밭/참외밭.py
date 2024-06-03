from sys import stdin
from collections import deque

def getSize(map):
    PATTERNS = ["231314", "231414", "231424", "232314"]
    pattern = deque()
    lengths = deque()

    # 주어진 map 데이터를 pattern과 lengths로 분리하여 저장
    for vector, length in map:
        pattern.append(str(vector))
        lengths.append(int(length))

    # 패턴을 회전시키며 PATTERNS에 있는지 확인
    for _ in range(len(pattern)):
        target = ''.join(pattern)
        if target in PATTERNS:
            patternType = PATTERNS.index(target)
            break
        pattern.append(pattern.popleft())
        lengths.append(lengths.popleft())

    # 패턴 유형에 따라 넓이를 계산하여 반환
    return calcSize(lengths, patternType)

def calcSize(lengths, pattern):
    if pattern == 0:
        return lengths[0] * lengths[5] - lengths[2] * lengths[3]
    elif pattern == 1:
        return lengths[0] * lengths[1] - lengths[3] * lengths[4]
    elif pattern == 2:
        return lengths[1] * lengths[2] - lengths[4] * lengths[5]
    elif pattern == 3:
        return lengths[4] * lengths[5] - lengths[1] * lengths[2]

def main():
    n = int(stdin.readline().strip())
    map_data = [tuple(map(int, stdin.readline().strip().split())) for _ in range(6)]
    size = getSize(map_data)
    print(n * size)

if __name__ == "__main__":
    main()
