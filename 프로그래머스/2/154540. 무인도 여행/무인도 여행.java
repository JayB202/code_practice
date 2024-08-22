import java.util.*;

class Solution {
    private int rows, cols;
    private boolean[][] visited;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        List<Integer> islands = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int days = dfs(maps, i, j);
                    islands.add(days);
                }
            }
        }

        if (islands.isEmpty()) {
            return new int[] { -1 };
        }

        Collections.sort(islands);
        return islands.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(String[] maps, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || maps[x].charAt(y) == 'X') {
            return 0;
        }

        visited[x][y] = true;
        int days = Character.getNumericValue(maps[x].charAt(y));

        days += dfs(maps, x + 1, y); // 아래로
        days += dfs(maps, x - 1, y); // 위로
        days += dfs(maps, x, y + 1); // 오른쪽으로
        days += dfs(maps, x, y - 1); // 왼쪽으로

        return days;
    }
}
