import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 수 입력
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            // 첫 번째 줄에서 문서 개수 N과 궁금한 문서의 위치 M 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 인덱스
            
            // 두 번째 줄에서 문서들의 중요도 입력
            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            int[] priorities = new int[10];  // 중요도를 1~9로 나누어 카운팅하기 위한 배열
            
            // 문서들을 큐에 추가하고, 중요도 배열에 카운팅
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[] { j, priority }); // {문서의 위치, 중요도}
                priorities[priority]++;
            }
            
            // 인쇄 순서
            int printOrder = 0;

            // 가장 높은 중요도를 저장하기 위한 변수
            int currentMaxPriority = 9;
            
            // 현재 인쇄할 문서의 순서를 찾기 위한 루프
            while (!queue.isEmpty()) {
                // 현재 중요도 중 가장 높은 중요도가 없으면 그보다 작은 중요도를 찾음
                while (priorities[currentMaxPriority] == 0) {
                    currentMaxPriority--;
                }
                
                // 큐의 맨 앞 문서 확인
                int[] current = queue.poll();
                
                // 현재 문서의 중요도가 현재 가장 높은 중요도와 같은지 확인
                if (current[1] == currentMaxPriority) {
                    // 인쇄 순서 증가
                    printOrder++;
                    priorities[currentMaxPriority]--;
                    
                    // 인쇄된 문서가 우리가 궁금한 문서(M)인지 확인
                    if (current[0] == m) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    // 현재 문서보다 높은 중요도가 있는 경우, 다시 큐의 맨 뒤로 보냄
                    queue.add(current);
                }
            }
        }
    }
}
