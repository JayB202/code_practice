class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;
        for (long i = l; i <= r; i++) {
            if (isOne(n, i)) {
                count++;
            }
        }
        return count;
    }

    // 특정 인덱스가 1인지 0인지 확인하는 함수
    private boolean isOne(int n, long index) {
        while (n > 0) {
            long segmentLength = (long) Math.pow(5, n - 1);  // 한 단계 아래 비트열의 길이
            long segmentPos = (index - 1) / segmentLength;   // 해당 인덱스가 속한 5분할 구간
            if (segmentPos == 2) {
                return false;  // 가운데 구간이면 0
            }
            // 가운데 구간이 아니면 그 구간에 해당하는 이전 비트열로 이동
            index = (index - 1) % segmentLength + 1;
            n--;
        }
         return true;  // n == 0일 때는 항상 1
    }

}



    
    