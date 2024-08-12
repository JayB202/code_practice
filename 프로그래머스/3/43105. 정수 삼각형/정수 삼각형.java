class Solution {
    public int solution(int[][] triangle) {
         int n = triangle.length;
        
        // DP를 위해 triangle 배열을 수정하며 최대 경로 합을 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 첫 번째 열의 경우, 바로 위의 값만 사용
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == i) {
                    // 마지막 열의 경우, 왼쪽 위의 값만 사용
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    // 그 외의 경우, 위쪽과 왼쪽 위 중 큰 값을 사용
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
        }
        
        // 마지막 행에서 최대값을 찾아 반환
        int answer = triangle[n-1][0];
        for (int j = 1; j < n; j++) {
            answer = Math.max(answer, triangle[n-1][j]);
        }
        
        return answer;
    }


}