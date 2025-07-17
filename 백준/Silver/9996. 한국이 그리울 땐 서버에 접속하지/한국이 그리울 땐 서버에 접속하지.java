import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] split = pattern.split("\\*");

        String prefix = split[0];
        String suffix = split[1];

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            if (fileName.length() >= prefix.length() + suffix.length() &&
                fileName.startsWith(prefix) &&
                fileName.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
