import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(weights);

        int sum = 0;
        for (int weight : weights) {
            if (weight > sum + 1) {
                break;
            }
            sum += weight;
        }

        System.out.println(sum + 1);
    }
}
