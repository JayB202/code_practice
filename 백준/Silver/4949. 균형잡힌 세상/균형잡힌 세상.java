import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String inputStr = sc.nextLine();
            
            // 종료 조건: 입력이 '.'일 경우
            if (inputStr.equals(".")) {
                break;
            }
            
            // 괄호 체크를 위한 스택
            Stack<Character> check = new Stack<>();
            String result = "yes";
            
            for (int i = 0; i < inputStr.length(); i++) {
                char c = inputStr.charAt(i);
                
                if (c == '(' || c == '[') {
                    check.push(c);  // 열린 괄호가 나오면 스택에 추가
                } else if (c == ')') {
                    if (check.isEmpty() || check.pop() != '(') {  // 열린 괄호가 없거나, 마지막에 들어간 괄호가 소괄호가 아닐 경우
                        result = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (check.isEmpty() || check.pop() != '[') {  // 열린 괄호가 없거나, 마지막에 들어간 괄호가 대괄호가 아닐 경우
                        result = "no";
                        break;
                    }
                }
            }
            
            // 스택에 남아있는 괄호가 있으면 잘못된 괄호 구조
            if (!check.isEmpty()) {
                result = "no";
            }
            
            // 결과 출력
            System.out.println(result);
        }
        
        sc.close();
    }
}
