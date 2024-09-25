import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 출력 효율을 위해 StringBuilder 사용
        
        // 스택 초기화
        Stack<Integer> stack = new Stack<>();
        
        // 명령의 수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 명령 처리
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "push":
                    // push 명령 처리: 스택에 정수 추가
                    stack.push(Integer.parseInt(command[1]));
                    break;
                
                case "pop":
                    // pop 명령 처리: 스택에서 가장 위의 정수 제거 및 출력
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                
                case "size":
                    // size 명령 처리: 스택의 크기 출력
                    sb.append(stack.size()).append("\n");
                    break;
                
                case "empty":
                    // empty 명령 처리: 스택이 비어 있는지 확인
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                
                case "top":
                    // top 명령 처리: 스택의 가장 위에 있는 정수 출력
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }
        
        // 모든 출력 한 번에 처리
        System.out.print(sb);
    }
}
