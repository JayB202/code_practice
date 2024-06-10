import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 심사 시간이 짧은 순으로 정렬
        Arrays.sort(times);

        // 가능한 최소 시간과 최대 시간 초기화
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        // 이진 탐색 시작
        while (left <= right) {
            long mid = (left + right) / 2; // 중간 값 설정
            long peopleProcessed = 0; // 중간 값 시간 동안 처리할 수 있는 사람 수

            // 각 심사대에서 중간 값 시간 동안 처리할 수 있는 사람 수 계산
            for (int time : times) {
                peopleProcessed += mid / time;
            }

            // 처리 가능한 사람이 대기 중인 사람 수보다 많거나 같으면 시간 줄이기
            if (peopleProcessed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                // 그렇지 않으면 시간 늘리기
                left = mid + 1;
            }
        }

        return answer;
    }
}
