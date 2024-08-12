public class Solution {
    public int solution(int n) {
        // 피보나치 수를 저장할 배열을 선언 및 초기화
        int[] pList = new int[n + 1];
        pList[0] = 0;
        pList[1] = 1;

        // 피보나치 수를 계산
        for (int i = 2; i <= n; i++) {
            pList[i] = (pList[i - 1] + pList[i - 2]) % 1234567;
        }

        return pList[n];
    }
}
