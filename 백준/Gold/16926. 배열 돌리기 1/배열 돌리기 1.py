def rotate_layer(layer, rotations):
    length = len(layer)
    rotations = rotations % length
    return layer[rotations:] + layer[:rotations]

def extract_layer(matrix, layer_num, N, M):
    layer = []
    for i in range(layer_num, M - layer_num):
        layer.append(matrix[layer_num][i])
    for i in range(layer_num + 1, N - layer_num):
        layer.append(matrix[i][M - layer_num - 1])
    for i in range(M - layer_num - 2, layer_num - 1, -1):
        layer.append(matrix[N - layer_num - 1][i])
    for i in range(N - layer_num - 2, layer_num, -1):
        layer.append(matrix[i][layer_num])
    return layer

def insert_layer(matrix, layer, layer_num, N, M):
    index = 0
    for i in range(layer_num, M - layer_num):
        matrix[layer_num][i] = layer[index]
        index += 1
    for i in range(layer_num + 1, N - layer_num):
        matrix[i][M - layer_num - 1] = layer[index]
        index += 1
    for i in range(M - layer_num - 2, layer_num - 1, -1):
        matrix[N - layer_num - 1][i] = layer[index]
        index += 1
    for i in range(N - layer_num - 2, layer_num, -1):
        matrix[i][layer_num] = layer[index]
        index += 1

def rotate_matrix(N, M, R, matrix):
    num_layers = min(N, M) // 2
    for layer_num in range(num_layers):
        layer = extract_layer(matrix, layer_num, N, M)
        rotated_layer = rotate_layer(layer, R)
        insert_layer(matrix, rotated_layer, layer_num, N, M)
    return matrix

# 입력 처리
N, M, R = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]

# 행렬 회전
result = rotate_matrix(N, M, R, matrix)

# 결과 출력
for row in result:
    print(' '.join(map(str, row)))
