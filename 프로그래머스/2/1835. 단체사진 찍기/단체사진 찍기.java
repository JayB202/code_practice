import java.util.*;

public class Solution {
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        permutation(new ArrayList<>(), new boolean[8], data);
        return answer;
    }
    
    void permutation(List<String> order, boolean[] visited, String[] data) {
        if (order.size() == 8) {
            if (check(order, data)) answer++;
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(friends[i]);
                permutation(order, visited, data);
                order.remove(order.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    boolean check(List<String> order, String[] data) {
        for (String cond : data) {
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char op = cond.charAt(3);
            int dist = cond.charAt(4) - '0';
            
            int idxA = order.indexOf(String.valueOf(a));
            int idxB = order.indexOf(String.valueOf(b));
            int gap = Math.abs(idxA - idxB) - 1;
            
            if (op == '=' && gap != dist) return false;
            if (op == '<' && gap >= dist) return false;
            if (op == '>' && gap <= dist) return false;
        }
        return true;
    }
}
