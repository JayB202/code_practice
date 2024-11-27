import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calculateBracketValue(input));
    }

    public static int calculateBracketValue(String input) {
        Stack<Character> stack = new Stack<>();
        int result = 0; // 최종 결과
        int temp = 1; // 현재 괄호값 계산에 사용

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0; // 올바르지 않은 괄호열
                }
                if (input.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0; // 올바르지 않은 괄호열
                }
                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        // 스택이 비어있지 않으면 올바르지 않은 괄호열
        return stack.isEmpty() ? result : 0;
    }
}
