import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        // 입력된 숫자를 문자열로 변환
        String str = Long.toString(n);
        
        // 문자열을 문자 배열로 변환
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        
        // 문자 배열을 내림차순으로 정렬
        Arrays.sort(chars, Collections.reverseOrder());
        
        // 정렬된 문자 배열을 문자열로 변환
        StringBuilder sortedStr = new StringBuilder();
        for (char c : chars) {
            sortedStr.append(c);
        }
        
        // 문자열을 long으로 변환
        long answer = Long.parseLong(sortedStr.toString());
        
        return answer;
    }
}
