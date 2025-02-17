from collections import defaultdict

# 유니온 파인드(Disjoint Set)를 위한 부모 배열 및 그룹 정보를 저장할 딕셔너리
MAX = 400000 + 400
parent = list(range(MAX))  # 각 노드의 부모 노드를 저장

degree = [0] * MAX  # 각 노드의 차수 (연결된 간선 개수)
root_group = defaultdict(int)  # 루트 그룹에 속한 노드 개수
non_root_group = defaultdict(int)  # 비루트 그룹에 속한 노드 개수

def find(a):
    """ 유니온 파인드에서 루트 노드를 찾는 함수 """
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])  # 경로 압축 최적화
    return parent[a]

def merge(a, b):
    """ 두 노드를 같은 그룹으로 병합하는 함수 """
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a  # 한쪽을 다른 쪽의 부모로 설정하여 그룹을 병합

def solution(nodes, edges):
    """
    주어진 노드 및 간선 정보를 바탕으로 홀짝 트리와 역홀짝 트리의 개수를 계산
    
    :param nodes: [int] 주어진 노드 리스트
    :param edges: [[int, int]] 주어진 간선 리스트
    :return: [홀짝 트리 개수, 역홀짝 트리 개수]
    """
    n = len(nodes)  # 노드 개수
    node2idx = {node: i for i, node in enumerate(nodes)}  # 노드 값 → 인덱스 변환 맵
    
    # 초기화: 각 노드의 부모를 자기 자신으로 설정
    for i in range(n):
        parent[i] = i
    
    # 간선 정보를 바탕으로 각 노드의 차수 계산
    for u, v in edges:
        u_idx, v_idx = node2idx[u], node2idx[v]
        degree[u_idx] += 1
        degree[v_idx] += 1
    
    # 간선 정보를 바탕으로 유니온 파인드로 연결
    for u, v in edges:
        merge(node2idx[u], node2idx[v])
    
    # 각 노드에 대해 그룹을 나눔
    for i in range(n):
        representative = find(i)  # 루트 노드를 찾음
        
        if (nodes[i] % 2) == (degree[i] % 2):  # 홀짝 트리의 조건
            root_group[representative] += 1
        else:  # 역홀짝 트리의 조건
            non_root_group[representative] += 1
    
    h_tree_count, r_tree_count = 0, 0  # 결과 값 초기화
    
    # 각 그룹을 탐색하여 홀짝 트리와 역홀짝 트리 개수 계산
    for i in range(n):
        if find(i) != i:  # 루트 노드가 아니면 건너뜀
            continue
        if root_group[i] == 1:  # 홀짝 트리가 가능한 경우
            h_tree_count += 1
        if non_root_group[i] == 1:  # 역홀짝 트리가 가능한 경우
            r_tree_count += 1
    
    return [h_tree_count, r_tree_count]
