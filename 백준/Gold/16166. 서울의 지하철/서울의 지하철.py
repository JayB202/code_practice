from sys import stdin

def bfs(start, cnt):
	togo = []
	for l in station[start]:
		for y in line[l]:
			if y == dest:
				return cnt
			if y not in visited:
				if len(station[y]) > 1:
					togo.append(y)
				visited.append(y)
	for x in togo:
		return bfs(x, cnt + 1)


n = int(stdin.readline().strip())
visited = []
line = {}
station = {}
for line_num in range(1, n + 1):
	tmp = list(map(int, stdin.readline().split()))
	line[line_num] = tmp[1:]
	for a in tmp[1:]:
		if a in station:
			station[a].append(line_num)
		else:
			station[a] = [line_num]

dest = int(stdin.readline().strip())
visited.append(0)
cnt = bfs(0, 0)
if cnt == None:
	print(-1)
else:
	print(cnt)