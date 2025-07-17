import java.util.*;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        int[][] gaveCount = new int[n][n]; // i가 j에게 준 선물 횟수
        int[] totalGave = new int[n];      // i가 준 선물 총합
        int[] totalGot = new int[n];       // i가 받은 선물 총합

        for (String record : gifts) {
            String[] parts = record.split(" ");
            int giver = idxMap.get(parts[0]);
            int receiver = idxMap.get(parts[1]);
            gaveCount[giver][receiver]++;
            totalGave[giver]++;
            totalGot[receiver]++;
        }

        int[] result = new int[n]; // 다음 달 받을 선물 수

        for (int i = 0; i < n; i++) {
            int giftIndexI = totalGave[i] - totalGot[i];
            for (int j = i + 1; j < n; j++) {
                int giftIndexJ = totalGave[j] - totalGot[j];
                int iToJ = gaveCount[i][j];
                int jToI = gaveCount[j][i];

                if (iToJ != jToI) {
                    // 더 많이 준 사람이 받음
                    if (iToJ > jToI) {
                        result[i]++;
                    } else {
                        result[j]++;
                    }
                } else {
                    // 주고받은 횟수 같거나 없음
                    if (giftIndexI > giftIndexJ) {
                        result[i]++;
                    } else if (giftIndexI < giftIndexJ) {
                        result[j]++;
                    }
                    // 같으면 선물 없음
                }
            }
        }

        int maxGift = 0;
        for (int count : result) {
            if (count > maxGift) maxGift = count;
        }
        return maxGift;
    }
}
