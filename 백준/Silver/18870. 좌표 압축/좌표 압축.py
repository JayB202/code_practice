# 입력 
#    첫번째줄 : 좌표 개수 N 
#    두번째줄 : 좌표 값 // 공백으로 구분

# 로직 
#    좌표 압축
#        -> 중복을 제거하고, 작은 값부터 매핑해서 사용
#        2 4 -10 4 -9   ->   2 3 0 3 1
# 


# 출력
#    압축한 좌표 배열을 띄어쓰기해서 출력



import sys

def coordinate_compression(coords):
    sorted_coords = sorted(set(coords))
    
    coord_map = {coord: index for index, coord in enumerate(sorted_coords)}
    
    compressed_coords = [coord_map[coord] for coord in coords]
    return compressed_coords

input = sys.stdin.read
data = input().split()

N = int(data[0])
coords = list(map(int,data[1:]))

compressed_list = coordinate_compression(coords)

print(' '.join(map(str, compressed_list)))

