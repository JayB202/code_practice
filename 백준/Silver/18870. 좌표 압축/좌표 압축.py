def coordinate_compression(coords):
    # 중복 제거 및 정렬
    sorted_unique_coords = sorted(set(coords))
    
    # 좌표 값 -> 압축된 값 매핑 생성
    coord_map = {coord: index for index, coord in enumerate(sorted_unique_coords)}
    
    # 원래 좌표 값을 압축된 값으로 변환
    compressed_coords = [coord_map[coord] for coord in coords]
    
    return compressed_coords

# 입력 받기
import sys
input = sys.stdin.read
data = input().split()

N = int(data[0])
coords = list(map(int, data[1:]))

# 좌표 압축 결과
compressed_coords = coordinate_compression(coords)

# 결과 출력
print(' '.join(map(str, compressed_coords)))
