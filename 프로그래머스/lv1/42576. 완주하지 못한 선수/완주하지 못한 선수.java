import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        

        
        HashMap<String, Integer> hash_map = new HashMap<>();
        for (String player : participant) hash_map.put(player, hash_map.getOrDefault(player, 0) + 1);
        for (String player : completion) hash_map.put(player, hash_map.get(player) - 1);

        for (String key : hash_map.keySet()) {
            if (hash_map.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}