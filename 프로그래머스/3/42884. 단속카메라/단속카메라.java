import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // 차량 경로를 끝 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int cameras = 0;
        int lastCamera = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            // 현재 차량의 진입 지점이 마지막 카메라 설치 지점을 지나친 경우
            if (route[0] > lastCamera) {
                // 새로운 카메라를 현재 차량의 끝 지점에 설치
                cameras++;
                lastCamera = route[1];
            }
        }
        
        return cameras;
    }
}
