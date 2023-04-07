import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] answer = {};
        answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) {
            answer = new int[] {-1};
        }
        Arrays.sort(answer);
        
        return answer;
    }
}