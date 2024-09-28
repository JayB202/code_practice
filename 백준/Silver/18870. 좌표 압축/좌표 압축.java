import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 좌표의 개수 N 읽기
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 좌표 값들 읽어오기
        String[] inputCoords = br.readLine().split(" ");
        int[] coords = new int[N];
        
        for (int i = 0; i < N; i++) {
            coords[i] = Integer.parseInt(inputCoords[i]);
        }
        
        // 좌표 압축 수행
        int[] compressedCoords = coordinateCompression(coords);
        
        // 압축된 좌표 출력
        StringBuilder sb = new StringBuilder();
        for (int coord : compressedCoords) {
            sb.append(coord).append(" ");
        }
        
        // 최종 결과 출력
        System.out.println(sb.toString().trim());
    }

    // 좌표 압축 함수
    public static int[] coordinateCompression(int[] coords) {
        // 배열 복사 후 정렬 및 중복 제거
        int[] sortedUniqueCoords = Arrays.stream(coords).distinct().sorted().toArray();
        
        // 원래 좌표 값을 압축된 값으로 변환할 맵 생성
        HashMap<Integer, Integer> coordMap = new HashMap<>();
        for (int i = 0; i < sortedUniqueCoords.length; i++) {
            coordMap.put(sortedUniqueCoords[i], i);
        }

        // 원래 좌표 값을 압축된 값으로 변환
        int[] compressedCoords = new int[coords.length];
        for (int i = 0; i < coords.length; i++) {
            compressedCoords[i] = coordMap.get(coords[i]);
        }

        return compressedCoords;
    }
}
