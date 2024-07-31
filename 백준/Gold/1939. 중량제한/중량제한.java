//1. N M 입력 - > N = 섬의 수  M  = 다리의 수
//1-1. 두번째 줄부터 M 줄 동안 다리의 시작 끝 중량 제한
//1-2. 마지막줄 공장 위치 ( 시작과 끝 )
// MST( Maximum Spanning Tree) -> kruskal 알고리즘
//2. 인접리스트 사용해서 각 엣지에 중량 제한 가중치 
//2-1. 엣지 중량 제한을 -> 내림차순 정리 - > UF(Union-Find) 구조로 사용하여 스패닝 트리 
//2-2. 경로 탐색
//3. 최대 옮길수 있는 중량 출력


import java.util.*;

public class Main{
    static int[] parent;
    static int[] rank;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //첫줄 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C  = sc.nextInt();
            edges.add(new Edge(A,B,C));
        }
        
        //마지막 줄
        int startFactory = sc.nextInt();
        int endFactory = sc.nextInt();
        
        parent = new int[N+1];
        rank = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        edges.sort((e1,e2) -> Integer.compare(e2.weight, e1.weight));
        
        
        //크루스칼 알고리즘
        
        int maxWeight = 0;
        for(Edge edge : edges){
            union(edge.from, edge.to);
            if (find(startFactory) == find(endFactory)){
                maxWeight = edge.weight;
                break;
            }
        }
        
        
        System.out.println(maxWeight);
    }
    
    
    static class Edge{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

