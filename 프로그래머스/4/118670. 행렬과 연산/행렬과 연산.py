from collections import deque

def solution(rc, operations):

    rows = len(rc)
    cols = len(rc[0])

    left_col = deque([rc[i][0] for i in range(rows)])
    right_col = deque([rc[i][cols - 1] for i in range(rows)]) 
    middle_rows = deque([deque(rc[i][1:cols - 1]) for i in range(rows)])

    for operation in operations:
        if operation == "ShiftRow":

            left_col.rotate(1)
            right_col.rotate(1)
            middle_rows.rotate(1)

        elif operation == "Rotate":
            top = middle_rows[0]
            top.appendleft(left_col.popleft())
            right_col.appendleft(top.pop())

            bottom = middle_rows[-1]
            bottom.append(right_col.pop())

            left_col.append(bottom.popleft())

    result = []
    for i in range(rows):
        result.append([left_col[i]] + list(middle_rows[i]) + [right_col[i]])

    return result