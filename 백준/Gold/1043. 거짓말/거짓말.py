def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a_root = find(parent, a)
    b_root = find(parent, b)
    if a_root != b_root:
        parent[b_root] = a_root

n, m = map(int, input().split())
truth = list(map(int, input().split()))
truth_people = set(truth[1:])

parent = [i for i in range(n + 1)]

parties = []
for _ in range(m):
    party = list(map(int, input().split()))
    people = party[1:]
    for i in range(len(people) - 1):
        union(parent, people[i], people[i + 1])
    parties.append(people)

# 진실을 아는 사람들의 root를 모두 저장
truth_roots = set(find(parent, person) for person in truth_people)

# 각 파티에서 모두 진실을 모르는 그룹이면 카운트
count = 0
for party in parties:
    if all(find(parent, person) not in truth_roots for person in party):
        count += 1

print(count)
