import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수의 등수를 저장하는 맵을 생성합니다.
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            result.put(players[i], i);
        }
        
        // 선수 순서를 관리하기 위해 ArrayList를 사용합니다.
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList(players));
        
        for (String who : callings) {
            int idx = result.get(who); // 호명된 선수의 현재 등수
            
            if (idx > 0) { // 호명된 선수가 첫 번째 자리가 아닐 경우
                // 현재 선수의 등수와 이전 선수의 등수를 업데이트합니다.
                String prevPlayer = playerList.get(idx - 1);
                
                // 등수 업데이트
                result.put(who, idx - 1);
                result.put(prevPlayer, idx);
                
                // 선수의 위치를 교환합니다.
                playerList.set(idx, prevPlayer);
                playerList.set(idx - 1, who);
            }
        }
        
        // 결과를 배열로 변환하여 반환합니다.
        return playerList.toArray(new String[0]);
    }
}