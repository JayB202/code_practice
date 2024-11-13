class TableEditor:
    def __init__(self):
        self.parent = {}
        self.value = {}

    def find(self, cell):
        if self.parent[cell] != cell:
            self.parent[cell] = self.find(self.parent[cell])
        return self.parent[cell]

    def union(self, cell1, cell2):
        root1 = self.find(cell1)
        root2 = self.find(cell2)
        
        if root1 != root2:
            # root1의 값이 우선 적용됨
            if root1 in self.value:
                self.parent[root2] = root1
            else:
                self.parent[root1] = root2

    def update_cell(self, r, c, value):
        cell = (r, c)
        root = self.find(cell)
        self.value[root] = value

    def update_value(self, old_value, new_value):
        for root in list(self.value):
            if self.value[root] == old_value:
                self.value[root] = new_value

    def merge(self, r1, c1, r2, c2):
        cell1 = (r1, c1)
        cell2 = (r2, c2)
        
        if cell1 not in self.parent:
            self.parent[cell1] = cell1
        if cell2 not in self.parent:
            self.parent[cell2] = cell2

        root1 = self.find(cell1)
        root2 = self.find(cell2)
        
        # 같은 그룹이면 무시
        if root1 == root2:
            return
        
        # root1의 값이 우선 적용됨
        if root1 in self.value:
            self.union(cell1, cell2)
        else:
            self.union(cell2, cell1)

    def unmerge(self, r, c):
        cell = (r, c)
        root = self.find(cell)
        
        # 셀의 값 가져오기
        if root in self.value:
            cell_value = self.value[root]
        else:
            cell_value = None

        # 병합 해제
        group = [k for k, v in self.parent.items() if self.find(v) == root]
        for member in group:
            self.parent[member] = member
            if member in self.value:
                del self.value[member]
                
        # 원래 값 복원
        if cell_value:
            self.value[cell] = cell_value

    def print_cell(self, r, c):
        cell = (r, c)
        root = self.find(cell)
        return self.value.get(root, "EMPTY")


def solution(commands):
    editor = TableEditor()
    editor.parent = {(r, c): (r, c) for r in range(1, 51) for c in range(1, 51)}
    
    result = []
    for command in commands:
        parts = command.split()
        
        if parts[0] == "UPDATE":
            if len(parts) == 4:
                # UPDATE r c value
                r, c, value = int(parts[1]), int(parts[2]), parts[3]
                editor.update_cell(r, c, value)
            else:
                # UPDATE value1 value2
                old_value, new_value = parts[1], parts[2]
                editor.update_value(old_value, new_value)
        
        elif parts[0] == "MERGE":
            r1, c1, r2, c2 = map(int, parts[1:])
            editor.merge(r1, c1, r2, c2)
        
        elif parts[0] == "UNMERGE":
            r, c = int(parts[1]), int(parts[2])
            editor.unmerge(r, c)
        
        elif parts[0] == "PRINT":
            r, c = int(parts[1]), int(parts[2])
            result.append(editor.print_cell(r, c))
    
    return result
