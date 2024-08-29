import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = 0;
        for (int pick : picks) {
            totalPicks += pick;
        }

        // 캘 수 있는 광물의 개수 계산
        int numMin = totalPicks * 5;
        if (minerals.length > numMin) {
            minerals = Arrays.copyOfRange(minerals, 0, numMin);
        }

        // 광물 조사
        int[][] cntMin = new int[(minerals.length + 4) / 5][3]; // dia, iron, stone
        for (int i = 0; i < minerals.length; i++) {
            int index = i / 5;
            if (minerals[i].equals("diamond")) {
                cntMin[index][0]++;
            } else if (minerals[i].equals("iron")) {
                cntMin[index][1]++;
            } else if (minerals[i].equals("stone")) {
                cntMin[index][2]++;
            }
        }

        // 피로도가 높은 순서대로 광물 정렬
        Arrays.sort(cntMin, (a, b) -> {
            int diff = b[0] - a[0];
            if (diff == 0) {
                diff = b[1] - a[1];
                if (diff == 0) {
                    diff = b[2] - a[2];
                }
            }
            return diff;
        });

        // 피로도 계산
        int answer = 0;
        for (int[] mineral : cntMin) {
            int d = mineral[0];
            int i = mineral[1];
            int s = mineral[2];
            for (int p = 0; p < picks.length; p++) {
                if (picks[p] > 0) {
                    if (p == 0) { // Diamond pickaxe
                        picks[p]--;
                        answer += d + i + s;
                    } else if (p == 1) { // Iron pickaxe
                        picks[p]--;
                        answer += 5 * d + i + s;
                    } else if (p == 2) { // Stone pickaxe
                        picks[p]--;
                        answer += 25 * d + 5 * i + s;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
