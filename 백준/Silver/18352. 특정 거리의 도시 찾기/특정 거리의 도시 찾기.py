import sys
from collections import deque

def main():
    input = sys.stdin.read
    data = input().splitlines()
    
    n, m, k, x = map(int, data[0].split())
    
    # Initialize the graph
    graph = [[] for _ in range(n + 1)]

    # Build the graph from input data
    for i in range(1, m + 1):
        a, b = map(int, data[i].split())
        graph[a].append(b)  # Add edge from city A to city B

    # Initialize distances array with -1
    result = [-1] * (n + 1)
    result[x] = 0  # Starting city distance is 0

    bfs(graph, x, result)

    found = False
    for i in range(1, n + 1):
        if result[i] == k:
            print(i)
            found = True
    if not found:
        print(-1)

def bfs(graph, start, result):
    queue = deque([start])

    while queue:
        city = queue.popleft()  # Current city

        # Check all connected cities
        for next_city in graph[city]:
            if result[next_city] == -1:  # If not visited
                result[next_city] = result[city] + 1  # Update distance
                queue.append(next_city)  # Add to queue

if __name__ == "__main__":
    main()
