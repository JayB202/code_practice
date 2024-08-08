import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        // 각 사이즈를 정렬하여 최소와 최대값
        for (int[] size : sizes) {
            Arrays.sort(size);
            maxWidth = Math.max(maxWidth, size[0]);
            maxHeight = Math.max(maxHeight, size[1]);
        }
        
        // 가로와 세로의 최대값을 곱하여 결과
        int answer = maxWidth * maxHeight;
        return answer;
    }
}
