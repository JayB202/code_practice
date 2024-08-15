import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 결과를 저장할 배열
        int[] answer = new int[targets.length];
        
        // 문자에 대한 최소 키 누르기 수를 저장할 맵
        Map<Character, Integer> keyDict = new HashMap<>();
        
        // 각 키맵을 통해 문자와 그 문자를 타이핑하기 위해 필요한 최소 횟수를 맵에 저장
        for (int i = 0; i < keymap.length; i++) {
            String keys = keymap[i];
            for (int j = 0; j < keys.length(); j++) {
                char c = keys.charAt(j);
                // 만약 문자 c가 이미 존재한다면, 기존 값과 비교하여 더 작은 값을 저장
                keyDict.put(c, Math.min(keyDict.getOrDefault(c, Integer.MAX_VALUE), j + 1));
            }
        }
        
        // 각 타겟 문자열에 대해 최소 타이핑 횟수를 계산
        for (int k = 0; k < targets.length; k++) {
            String target = targets[k];
            int sum = 0;
            for (int m = 0; m < target.length(); m++) {
                char c = target.charAt(m);
                // 문자 c가 맵에 존재하지 않으면 -1로 설정하고 루프 종료
                if (keyDict.containsKey(c)) {
                    sum += keyDict.get(c);
                } else {
                    sum = -1;
                    break;
                }
            }
            answer[k] = sum;
        }
        
        return answer;
    }
}
