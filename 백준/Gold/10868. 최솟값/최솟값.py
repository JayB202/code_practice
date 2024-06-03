import sys
input = sys.stdin.read

class SegmentTree:
    def __init__(self, data):
        self.n = len(data)
        self.tree = [0] * (4 * self.n)
        self.build(data, 0, 0, self.n - 1)
        
    def build(self, data, node, start, end):
        if start == end:
            self.tree[node] = data[start]
        else:
            mid = (start + end) // 2
            self.build(data, 2 * node + 1, start, mid)
            self.build(data, 2 * node + 2, mid + 1, end)
            self.tree[node] = min(self.tree[2 * node + 1], self.tree[2 * node + 2])
    
    def query(self, L, R, node, start, end):
        if R < start or end < L:
            return float('inf')
        if L <= start and end <= R:
            return self.tree[node]
        mid = (start + end) // 2
        left_query = self.query(L, R, 2 * node + 1, start, mid)
        right_query = self.query(L, R, 2 * node + 2, mid + 1, end)
        return min(left_query, right_query)
    
    def range_query(self, L, R):
        return self.query(L, R, 0, 0, self.n - 1)

def main():
    input_data = input().strip().split()
    N = int(input_data[0])
    M = int(input_data[1])
    
    data = [int(input_data[i]) for i in range(2, 2 + N)]
    queries = [(int(input_data[2 + N + 2 * i]) - 1, int(input_data[2 + N + 2 * i + 1]) - 1) for i in range(M)]
    
    segment_tree = SegmentTree(data)
    
    results = []
    for a, b in queries:
        result = segment_tree.range_query(a, b)
        results.append(result)
    
    print('\n'.join(map(str, results)))

if __name__ == "__main__":
    main()