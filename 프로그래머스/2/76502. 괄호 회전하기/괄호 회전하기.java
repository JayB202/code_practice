import java.util.Stack;

public class Solution {
    public static int solution(String s) {
        if (s.length() % 2 == 1) {
            return 0;
        }
        
        char[] opening = {'[', '(', '{'};
        char[] closing = {']', ')', '}'};
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            if (isValid(sb.toString())) {
                answer++;
            }
            // 회전 시키기
            sb.append(sb.charAt(0)).deleteCharAt(0);
        }
        
        return answer;
    }
    
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '[':
                case '(':
                case '{':
                    stack.push(ch);
                    break;
                case ']':
                case ')':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (!isMatchingPair(top, ch)) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char open, char close) {
        return (open == '[' && close == ']') ||
               (open == '(' && close == ')') ||
               (open == '{' && close == '}');
    }
    

}
