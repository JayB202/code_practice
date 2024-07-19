import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
            int N = Integer.parseInt(line.trim());
            if (N >= 0 && N <= 12) {
                char[] result = generateCantorSet(N);
                System.out.println(new String(result));
            }
        }
    }

    // 칸토어 집합을 생성하는 메소드
    private static char[] generateCantorSet(int N) {
        int size = (int) Math.pow(3, N);
        char[] cantorSet = new char[size];
        for (int i = 0; i < size; i++) {
            cantorSet[i] = '-';
        }
        applyCantorSet(cantorSet, 0, size - 1, N);
        return cantorSet;
    }

    // 칸토어 집합을 재귀적으로 적용하는 메소드
    private static void applyCantorSet(char[] array, int start, int end, int N) {
        if (N == 0) return;
        
        int length = end - start + 1;
        int third = length / 3;
        int middleStart = start + third;
        int middleEnd = start + 2 * third - 1;
        
        // 가운데 구간을 공백으로 설정
        for (int i = middleStart; i <= middleEnd; i++) {
            array[i] = ' ';
        }
        
        // 재귀 호출
        applyCantorSet(array, start, start + third - 1, N - 1);
        applyCantorSet(array, end - third + 1, end, N - 1);
    }
}
