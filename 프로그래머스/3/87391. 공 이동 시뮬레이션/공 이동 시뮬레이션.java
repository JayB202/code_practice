class Solution {
    public long solution(int n, int m, int targetRow, int targetCol, int[][] queries) {
        // 시작 위치와 도달 가능한 위치를 초기화
        long startRow = targetRow;
        long startCol = targetCol;
        long endRow = targetRow;
        long endCol = targetCol;

        // 쿼리를 역방향으로
        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            long delta = queries[i][1];

            switch (command) {
                case 0: // 열 번호가 감소하는 방향으로 이동한 쿼리
                    if (startCol == 0) {
                        endCol = Math.min(m - 1, endCol + delta);
                    } else {
                        if (startCol + delta >= m) return 0;
                        startCol = Math.min(m - 1, startCol + delta);
                        endCol = Math.min(m - 1, endCol + delta);
                    }
                    break;

                case 1: // 열 번호가 증가하는 방향으로 이동한 쿼리
                    if (endCol == m - 1) {
                        startCol = Math.max(0, startCol - delta);
                    } else {
                        if (endCol - delta < 0) return 0;
                        startCol = Math.max(0, startCol - delta);
                        endCol = Math.max(0, endCol - delta);
                    }
                    break;

                case 2: // 행 번호가 감소하는 방향으로 이동한 쿼리
                    if (startRow == 0) {
                        endRow = Math.min(n - 1, endRow + delta);
                    } else {
                        if (startRow + delta >= n) return 0;
                        startRow = Math.min(n - 1, startRow + delta);
                        endRow = Math.min(n - 1, endRow + delta);
                    }
                    break;

                case 3: // 행 번호가 증가하는 방향으로 이동한 쿼리
                    if (endRow == n - 1) {
                        startRow = Math.max(0, startRow - delta);
                    } else {
                        if (endRow - delta < 0) return 0;
                        startRow = Math.max(0, startRow - delta);
                        endRow = Math.max(0, endRow - delta);
                    }
                    break;
            }
        }

        // 가능한 시작점의 개수를 계산
        long numberOfRows = Math.max(0, endRow - startRow + 1);
        long numberOfCols = Math.max(0, endCol - startCol + 1);

        return numberOfRows * numberOfCols;
    }
}