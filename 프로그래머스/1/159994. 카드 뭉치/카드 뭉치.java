import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // LinkedList를 사용하여 pop 연산의 효율을 높임 (  O (1) //Array 경우 O(N))
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList(cards1));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList(cards2));
        
        for (String word : goal) {
            // goal의 현재 단어와 cards1의 첫 번째 단어가 같으면 cards1에서 제거
            if (!list1.isEmpty() && word.equals(list1.getFirst())) {
                list1.removeFirst();
            }
            // goal의 현재 단어와 cards2의 첫 번째 단어가 같으면 cards2에서 제거
            else if (!list2.isEmpty() && word.equals(list2.getFirst())) {
                list2.removeFirst();
            }
            // 현재 단어가 cards1과 cards2의 첫 번째 단어와도 일치하지 않으면 실패
            else {
                return "No";
            }
        }
        // 모든 단어를 성공적으로 처리하면 "Yes" 반환
        return "Yes";
    }
}
