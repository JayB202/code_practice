N = int(input())

K = int(input())

sensors = sorted(set(list(map(int, input().split()))))

diff = []

for i in range(1, len(sensors)):
    diff.append(sensors[i]-sensors[i-1])

diff.sort()

print(sum(diff[:len(sensors)-K]))