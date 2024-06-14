import heapq
import sys
input = sys.stdin.read

def dijkstra(graph, start):
    N = len(graph)
    distances = [float('inf')] * N
    distances[start] = 0
    queue = [(0, start)]
    while queue:
        current_distance, current_node = heapq.heappop(queue)
        if current_distance > distances[current_node]:
            continue
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))
    return distances

def main():
    data = input().split()
    idx = 0
    
    N = int(data[idx])
    idx += 1
    E = int(data[idx])
    idx += 1
    
    graph = [[] for _ in range(N + 1)]
    for _ in range(E):
        a = int(data[idx])
        idx += 1
        b = int(data[idx])
        idx += 1
        c = int(data[idx])
        idx += 1
        graph[a].append((b, c))
        graph[b].append((a, c))
    
    v1 = int(data[idx])
    idx += 1
    v2 = int(data[idx])
    idx += 1
    
    # Compute shortest paths from 1, v1, and v2
    dist_from_1 = dijkstra(graph, 1)
    dist_from_v1 = dijkstra(graph, v1)
    dist_from_v2 = dijkstra(graph, v2)
    
    # Calculate the two possible routes
    route1 = dist_from_1[v1] + dist_from_v1[v2] + dist_from_v2[N]
    route2 = dist_from_1[v2] + dist_from_v2[v1] + dist_from_v1[N]
    
    # Find the minimum distance
    result = min(route1, route2)
    
    # If the result is infinite, it means there is no possible route
    if result == float('inf'):
        print(-1)
    else:
        print(result)

if __name__ == "__main__":
    main()
