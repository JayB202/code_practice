import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // daldidalgo의 횟수
		
		// 첫 daldidalgo를 만들때 8초가 소모된다.
		int count = 8;
		
		for (int i = 1; ; i++) {
			if (n - Math.pow(2, i) == 0) {
				count = count + i + 2; // 복사를 i번, daldidan만드는데 2초 소모된다.
				break;
			} else if (n - Math.pow(2, i) < 0) {
				count = count + i + 1; // 복사를 i번, daldidan만드는데 1초 소모된다.
				break;
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
