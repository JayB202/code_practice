import java.util.*;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> chickenHouses = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 도시 크기 및 최대 치킨집 수 입력
        N = scanner.nextInt();
        M = scanner.nextInt();
        city = new int[N][N];

        // 도시 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = scanner.nextInt();
                if (city[i][j] == 1) { // 집
                    houses.add(new int[]{i, j});
                } else if (city[i][j] == 2) { // 치킨집
                    chickenHouses.add(new int[]{i, j});
                }
            }
        }

        // 조합을 통해 치킨집 선택
        chooseChickenHouses(0, 0, new int[M], 0);
        System.out.println(minChickenDistance);
    }

    // 치킨집 조합 선택
    static void chooseChickenHouses(int start, int depth, int[] selected, int count) {
        if (depth == M) {
            // 선택한 치킨집에 대해 치킨 거리 계산
            calculateChickenDistance(selected);
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            selected[depth] = i; // 치킨집 인덱스 저장
            chooseChickenHouses(i + 1, depth + 1, selected, count + 1);
        }
    }

    // 선택된 치킨집에 대한 총 치킨 거리 계산
    static void calculateChickenDistance(int[] selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int index : selected) {
                int[] chicken = chickenHouses.get(index);
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }

        minChickenDistance = Math.min(minChickenDistance, totalDistance);
    }
}
