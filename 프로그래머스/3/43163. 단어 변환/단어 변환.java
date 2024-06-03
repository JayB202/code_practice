import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words 리스트가 target을 포함하지 않으면 변환 불가능하므로 0 반환
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // BFS를 위한 큐와 방문 여부 체크를 위한 셋
        Queue<WordNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 시작 단어를 큐에 추가하고 방문 처리
        queue.offer(new WordNode(begin, 0));
        visited.add(begin);

        // BFS 탐색
        while (!queue.isEmpty()) {
            WordNode current = queue.poll();
            String currentWord = current.word;
            int currentStep = current.step;

            // 모든 단어를 순회하며 한 글자만 다른 단어를 찾음
            for (String word : words) {
                if (!visited.contains(word) && isOneLetterDifferent(currentWord, word)) {
                    if (word.equals(target)) {
                        return currentStep + 1;
                    }
                    queue.offer(new WordNode(word, currentStep + 1));
                    visited.add(word);
                }
            }
        }

        // 변환할 수 없는 경우 0 반환
        return 0;
    }

    // 두 단어가 한 글자만 다른지 확인하는 함수
    private boolean isOneLetterDifferent(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    // 단어와 현재 단계 수를 저장하는 클래스
    class WordNode {
        String word;
        int step;

        WordNode(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
