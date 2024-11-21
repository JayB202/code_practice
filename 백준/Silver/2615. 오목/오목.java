//  1 . 바둑판을 입력 받고 저장 ( 19x 19 -> 한칸씩 띄워져 있다고 했어요 - > 배열로 저잘할 예정)

//  2 . 바둑판을 탐색하면서, 이긴 돌을 찾기  (검은돌 : 1, 흰돌 :2 , 없으면 : 0)
//      2-1. 현재 바둑알 색깔 을 판별 
//      2-2. 방향을 줘서 5개 연속 여부 판별
//         2-2-1. 돌이 발견되면, 상하좌우대각선에 같은색 돌이 있는지 찾기
//         2-2-2. 연속으로 돌이 있는지 확인  ( 카운트 활용 예정)
//      2-3. 6목 체크
//      2-4. 이긴돌 확인.
//      2-5. 모든 위치 탐색 했을때 이긴돌이 없으면 0 리턴, 



import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //바둑판 저장
        int[][] board = new int[19][19];
        for(int i = 0; i< 19;i++){
            for (int j = 0; j < 19; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        
        //바둑판 탐색
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                //바둑알이 있음
                if (board[i][j] != 0){
                    int dolColor = board[i][j];
                    //가로세로대각선 방향의 돌을 검색
                    for(int d = 0; d < 4; d++){
                        if(ohmok(board, i, j, dolColor, d)){
                            System.out.println(dolColor);
                            System.out.println((i+1) + " " + (j + 1));
                            return;
                        }
                    }
                }
                           
            }
        }
      System.out.println(0);
    } 
                           
    //디렉션 값
    static int[] dx = {0, 1, 1, -1};
    static int[] dy= {1, 0, 1, 1};
    
    //방향 별 돌 탐색
    public static boolean ohmok(int[][] board, int x, int y, int color, int direction){
        int count = 1;
        //돌 방향 
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        
        //연속된 돌 세기  +  nx ny 가 바둑판 안에 있어야겠죠
        while(inBoard(nx, ny) && board[nx][ny] == color  ){
            count ++;
            nx += dx[direction];
            ny += dy[direction];
        }
        
        //연속된 바둑돌의 갯수에 따라서~
        if(count == 5){
            nx = x- dx[direction];
            ny = y- dy[direction];
            if(inBoard(nx, ny) && board[nx][ny] == color){
                return false;
            }
            
            nx = x + 5 * dx[direction];
            ny = y + 5 * dy[direction];
            if(inBoard(nx, ny) && board[nx][ny] == color){
                return false;
            }
         
            return true;
        }
        
        return false;
    }
    
    public static boolean inBoard(int x, int y){
        return x>= 0 && x <19 && y >= 0 && y<19;
    }
    
       
    
}
