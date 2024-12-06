// 입력 N, M   ( N 개줄 M 개수)
//        NXM 배열 ( 각 위치의 가치)
// 로직 
// 로봇이 좌 우 하 이동 가능 / 위쪽 x 
//     탐사지역 재탐색 x 
//             ->dP 를 통해서, 각 좌표에 도달하는 최댓값을 만들어주고
//                    -> 업데이트 해가면서 마지막 좌표으 ㅣ최댓값
//                -> 좌 우로 이동 가능하니까, 좌스캔 우스캔
//                -> 1,1  첫줄에선 우스캔하면 될듯

// 출력 :  1,1 -> n,m 갔을때, 이동경로상으 ㅣ숫자의 합이 최대가 되는 숫자 출력

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //첫째줄
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        //다음 N 줄
        int[][] map = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M; j++ ){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        //DP 배열
        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];
        
        
        //첫번째줄 우스캔
        for(int j = 1; j < M; j++){
            dp[0][j] = map[0][j] + dp[0][j-1];
        }
            
        for (int i = 1; i < N; i++){
            //우스캔
            int[] leftToRight = new int[M];
            leftToRight[0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < M; j++){
                leftToRight[j] = Math.max(leftToRight[j-1], dp[i-1][j]) + map[i][j];
            }
            
            //좌스캔
            int[] rightToLeft = new int[M];
            rightToLeft[M-1] = dp[i-1][M-1] +map[i][M-1];
            for (int j = M-2; j >= 0; j--){
                rightToLeft[j] = Math.max(rightToLeft[j+1], dp[i-1][j]) + map[i][j];
            }
            
            //최종적으로 DP 값 확정       
            for (int j = 0 ; j < M; j++){
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }
        
        System.out.println(dp[N-1][M-1]);
        
    } 
}

