// 입력 : r1 ,c1, r2, c2  - > 이게 각 모서리죠 
// 로직 :  소용돌이를 전체를 만들어서 구간만큼 떼어오는 방식 -- > 시뮬레이션
//        점화식을 통해서 r1, c1, r2, c2 에 들어갈 소용돌이만 만드는 방식
//            패턴파악=- > (0, 0)에서 시작하고 한바퀴씩 돎? 
//                    -> 정사각형이 만들어지는데, 각변의 길이가, 3 5 7 9~ 
//                                                             (2n+1)   
//                    ->각 정사각형 최댓값 9 25 49 ->  (2n+1)^2
//                    -> 최댓값 위치 ->  (n,n)
//                            각 소용돌이 레이어마다 어떤게 최댓값인지 구할수 있을거고,
//                               -> 각 좌표마다 값을 구할수 있게죠


// 출력 : r1, c1, r2,c2 범위에 있는 소용돌이 출력

//시뮬레이션
// 점화식

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);
        
        int maxDigits = 0;
        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j ++){
                maxDigits = Math.max(maxDigits, digitCount(calVal(i, j)));
            }
        }
        
        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                 bw.write(String.format("%" + maxDigits + "d ", calVal(i, j)));
            }
            bw.newLine();
        }        

        bw.flush();
        br.close();
        bw.close();
    }
    
    public static int calVal(int i, int j){
        int n = Math.max(Math.abs(i), Math.abs(j)); 
        int maxVal = (2 * n + 1) * (2 * n + 1); 
        
        int temp = 2 * n;
        if (i == n) return maxVal - (n-j);
        maxVal -= temp;
        if (j == -n) return maxVal - (n-i);
        maxVal -= temp;
        if (i == -n) return maxVal - (n+j);
        maxVal -= temp;
        return maxVal - (n+i);
    }
    
    public static int digitCount(int val){
        return val == 0 ? 1 : (int) Math.log10(val) + 1;
    }
}
    