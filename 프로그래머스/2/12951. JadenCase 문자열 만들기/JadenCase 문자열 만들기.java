public class Solution {
     public static String solution(String s) {
        // 입력 문자열의 앞뒤 공백을 구분
        int startIndex = 0;
        int endIndex = s.length() - 1;

        // 문자열의 앞 공백 개수 확인
        while (startIndex < s.length() && s.charAt(startIndex) == ' ') {
            startIndex++;
        }

        // 문자열의 뒤 공백 개수 확인
        while (endIndex >= 0 && s.charAt(endIndex) == ' ') {
            endIndex--;
        }
         
        // 입력 문자열을 공백을 기준으로 분리
        String[] words = s.split(" ");
        // 결과를 저장할 StringBuilder 객체 생성
        StringBuilder result = new StringBuilder();
        
        // 각 단어에 대해 첫 글자를 대문자로 변환
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase());
            }
            result.append(" ");
        }
        
        // 마지막 공백 제거 후 앞뒤 공백 추가 및 결과 반환
         return " ".repeat(startIndex) + result.toString().trim() + " ".repeat(s.length() - endIndex - 1);
    }
}