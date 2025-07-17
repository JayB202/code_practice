import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char gameType = st.nextToken().charAt(0);

        Set<String> players = new HashSet<>();
        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        int required = 0;
        if (gameType == 'Y') required = 2;
        else if (gameType == 'F') required = 3;
        else if (gameType == 'O') required = 4;

        System.out.println(players.size() / (required - 1));
    }
}
