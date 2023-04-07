import java.util.Arrays;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        answer = (double) Arrays.stream(arr).sum()/arr.length;
        return answer;
    }
}