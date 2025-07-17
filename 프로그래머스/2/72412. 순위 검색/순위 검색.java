import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] split = s.split(" ");
            addInfo(split, "", 0, Integer.parseInt(split[4]));
        }

        // 점수 오름차순 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        List<Integer> answerList = new ArrayList<>();
        for (String q : query) {
            String[] tokens = q.replaceAll(" and ", " ").split(" ");
            String key = String.join("", tokens[0], tokens[1], tokens[2], tokens[3]);
            int score = Integer.parseInt(tokens[4]);

            if (map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                int idx = lowerBound(scores, score);
                answerList.add(scores.size() - idx);
            } else {
                answerList.add(0);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    void addInfo(String[] info, String key, int depth, int score) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        addInfo(info, key + info[depth], depth + 1, score);
        addInfo(info, key + "-", depth + 1, score);
    }

    int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
