from collections import defaultdict

def find(parent, a):
    if parent[a] == a:
        return a
    parent[a] = find(parent, parent[a])
    return parent[a]

def merge(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a != b:
        parent[b] = a

def solution(nodes, edges):
    n = len(nodes)
    parent = {node: node for node in nodes}
    degree = defaultdict(int)
    root_group = defaultdict(int)
    non_root_group = defaultdict(int)
    node2idx = {nodes[i]: i for i in range(n)}
    
    for edge in edges:
        u, v = edge
        degree[u] += 1
        degree[v] += 1
    
    for edge in edges:
        u, v = edge
        merge(parent, u, v)
    
    for node in nodes:
        representative = find(parent, node)
        if (node % 2) == (degree[node] % 2):
            root_group[representative] += 1
        else:
            non_root_group[representative] += 1
    
    h_tree_count = 0
    r_tree_count = 0
    
    for node in nodes:
        if find(parent, node) != node:
            continue
        if root_group[node] == 1:
            h_tree_count += 1
        if non_root_group[node] == 1:
            r_tree_count += 1
    
    return [h_tree_count, r_tree_count]
