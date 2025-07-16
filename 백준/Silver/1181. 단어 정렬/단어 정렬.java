import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 중복 제거 + 입력 순서 유지 위해 LinkedHashSet 사용
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        List<String> words = new ArrayList<>(set);
        
        // 길이 우선 정렬, 길이 같으면 사전 순 정렬
        Collections.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        
        for (String word : words) {
            System.out.println(word);
        }
    }
}