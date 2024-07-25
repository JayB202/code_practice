class Solution {
    public int solution(String s) {
        int n = s.length();
        int minLength = n; // 초기값은 전체 문자열 길이

        // 1부터 문자열 길이까지의 단위로 자르기
        for (int unit = 1; unit <= n / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit); // 현재 단위 문자열
            int count = 1;

            // 문자열을 unit 크기로 자르면서 압축
            for (int i = unit; i < n; i += unit) {
                String current;
                // 현재 문자열의 길이가 단위보다 작을 수 있으므로 주의
                if (i + unit <= n) {
                    current = s.substring(i, i + unit);
                } else {
                    current = s.substring(i);
                }

                if (current.equals(prev)) {
                    count++;
                } else {
                    compressed.append(count > 1 ? count : "").append(prev);
                    prev = current;
                    count = 1;
                }
            }
            // 마지막 부분 추가
            compressed.append(count > 1 ? count : "").append(prev);

            // 압축된 문자열의 길이
            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}