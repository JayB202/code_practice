import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 읽어들이기
        int N = sc.nextInt();
        // 문제를 저장하는 데이터 구조
        Map<Integer, Integer> problemMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> difficultyMap = new TreeMap<>();
        
        // 문제 리스트를 초기화
        for (int i = 0; i < N; i++) {
            int P = sc.nextInt();
            int L = sc.nextInt();
            
            problemMap.put(P, L);
            difficultyMap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
        }
        
        // 명령어 처리
        int M = sc.nextInt();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            String command = sc.next();
            
            if (command.equals("recommend")) {
                int x = sc.nextInt();
                
                if (x == 1) {
                    // 가장 높은 난이도
                    Map.Entry<Integer, TreeSet<Integer>> entry = difficultyMap.lastEntry();
                    int maxDifficulty = entry.getKey();
                    int maxProblem = entry.getValue().last();
                    result.add(String.valueOf(maxProblem));
                } else if (x == -1) {
                    // 가장 낮은 난이도
                    Map.Entry<Integer, TreeSet<Integer>> entry = difficultyMap.firstEntry();
                    int minDifficulty = entry.getKey();
                    int minProblem = entry.getValue().first();
                    result.add(String.valueOf(minProblem));
                }
                
            } else if (command.equals("add")) {
                int P = sc.nextInt();
                int L = sc.nextInt();
                
                if (problemMap.containsKey(P)) {
                    int oldDifficulty = problemMap.get(P);
                    difficultyMap.get(oldDifficulty).remove(P);
                    if (difficultyMap.get(oldDifficulty).isEmpty()) {
                        difficultyMap.remove(oldDifficulty);
                    }
                }
                
                problemMap.put(P, L);
                difficultyMap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
                
            } else if (command.equals("solved")) {
                int P = sc.nextInt();
                
                if (problemMap.containsKey(P)) {
                    int L = problemMap.get(P);
                    difficultyMap.get(L).remove(P);
                    if (difficultyMap.get(L).isEmpty()) {
                        difficultyMap.remove(L);
                    }
                    problemMap.remove(P);
                }
            }
        }
        
        // 결과 출력
        System.out.println(String.join("\n", result));
        sc.close();
    }
}
