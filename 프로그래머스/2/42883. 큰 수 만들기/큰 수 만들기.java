import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        int removeCount = 0;

        // 숫자를 하나씩 처리
        for (int i = 0; i < length; i++) {
            char currentChar = number.charAt(i);
            
            // 현재 숫자가 스택의 top 숫자보다 크면, top 숫자를 제거
            while (!stack.isEmpty() && removeCount < k && stack.peek() < currentChar) {
                stack.pop();
                removeCount++;
            }
            
            stack.push(currentChar);
        }

        // 만약 제거할 숫자가 아직 남아 있다면, 스택의 끝에서 제거
        while (removeCount < k) {
            stack.pop();
            removeCount++;
        }

        // 스택에 남아 있는 숫자들을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
