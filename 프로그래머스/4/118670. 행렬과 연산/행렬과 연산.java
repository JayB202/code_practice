import java.util.*;

public class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int numRows = rc.length;
        int numCols = rc[0].length;
        
        // 각 부분을 deque로 관리
        Deque<Integer> leftColumn = new ArrayDeque<>();
        Deque<Integer> rightColumn = new ArrayDeque<>();
        Deque<Deque<Integer>> middleColumns = new ArrayDeque<>();
        
        // 왼쪽 열, 오른쪽 열, 가운데 열 초기화
        for (int i = 0; i < numRows; i++) {
            leftColumn.add(rc[i][0]);
            rightColumn.add(rc[i][numCols - 1]);
            
            Deque<Integer> middleRow = new ArrayDeque<>();
            for (int j = 1; j < numCols - 1; j++) {
                middleRow.add(rc[i][j]);
            }
            middleColumns.add(middleRow);
        }
        
        // 연산 처리
        for (String operation : operations) {
            if (operation.equals("ShiftRow")) {
                // ShiftRow 연산: 행들을 아래로 한 칸씩 이동
                leftColumn.addFirst(leftColumn.removeLast());
                rightColumn.addFirst(rightColumn.removeLast());
                middleColumns.addFirst(middleColumns.removeLast());
            } else if (operation.equals("Rotate")) {
                // Rotate 연산: 테두리 요소들을 시계 방향으로 한 칸씩 회전
                // 위쪽 행에서 오른쪽으로 이동
                Deque<Integer> topRow = middleColumns.peekFirst();
                topRow.addFirst(leftColumn.removeFirst());
                rightColumn.addFirst(topRow.removeLast());
                
                // 오른쪽 열에서 아래로 이동
                Deque<Integer> bottomRow = middleColumns.peekLast();
                bottomRow.add(rightColumn.removeLast());
                
                // 아래쪽 행에서 왼쪽으로 이동
                leftColumn.add(bottomRow.removeFirst());
            }
        }
        
        // 최종 행렬을 구성
        int[][] resultMatrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            resultMatrix[i][0] = leftColumn.removeFirst();
            resultMatrix[i][numCols - 1] = rightColumn.removeFirst();
            
            Deque<Integer> middleRow = middleColumns.removeFirst();
            for (int j = 1; j < numCols - 1; j++) {
                resultMatrix[i][j] = middleRow.removeFirst();
            }
        }
        
        return resultMatrix;
    }
}
