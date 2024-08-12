public class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // n이 2보다 작은 경우는 기본적으로 n을 반환
        if (n < 2) {
            answer = n;
        } else {
            // n개의 칸을 저장할 배열을 초기화
            int[] f_n = new int[n];
            f_n[0] = 1; // 1칸일 때 가능한 방법의 수는 1가지
            f_n[1] = 2; // 2칸일 때 가능한 방법의 수는 2가지 (1+1, 2)

            // 3칸 이상의 경우는 점화식을 이용하여 계산
            for (int i = 2; i < n; i++) {
                f_n[i] = (f_n[i - 2] + f_n[i - 1]) % 1234567;
            }

            // 마지막 칸에 도달하는 방법의 수를 반환
            answer = f_n[n - 1];
        }

        return answer;
    }
}
