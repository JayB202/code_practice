import java.util.*;

public class Main {

    static int N, M;
    static int[][] city;
    static List<int[]> homeList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = scanner.nextInt();
                if (city[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        // Generate all combinations of M chicken stores from chickenList
        List<int[]> chickenCombinations = new ArrayList<>();
        combineChickenStores(0, 0, new int[M], chickenCombinations);

        // Calculate minimum city chicken distance for each combination
        for (int[] combination : chickenCombinations) {
            minDistance = Math.min(minDistance, calculateCityChickenDistance(combination));
        }

        System.out.println(minDistance);
        scanner.close();
    }

    // Generate all combinations of M chicken stores
    private static void combineChickenStores(int start, int depth, int[] combination, List<int[]> chickenCombinations) {
        if (depth == M) {
            chickenCombinations.add(combination.clone());
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            combination[depth] = i;
            combineChickenStores(i + 1, depth + 1, combination, chickenCombinations);
        }
    }

    // Calculate the city chicken distance for the given combination of chicken stores
    private static int calculateCityChickenDistance(int[] combination) {
        int totalDistance = 0;
        for (int[] home : homeList) {
            int homeRow = home[0];
            int homeCol = home[1];
            int minDistance = Integer.MAX_VALUE;

            for (int index : combination) {
                int[] chicken = chickenList.get(index);
                int chickenRow = chicken[0];
                int chickenCol = chicken[1];
                int distance = Math.abs(homeRow - chickenRow) + Math.abs(homeCol - chickenCol);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }
        return totalDistance;
    }
}
