class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            // 6 ~ 9
            if (remainder > 5) {
                answer += (10 - remainder);
                storey += 10;
            }
            // 0 ~ 4
            else if (remainder < 5) {
                answer += remainder;
            }
            // 5
            else {
                if ((storey / 10) % 10 > 4) {
                    storey += 10;
                }
                answer += remainder;
            }
            storey /= 10;
        }

        return answer;
    }
}
