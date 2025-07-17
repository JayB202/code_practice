import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] students = br.readLine().split(" ");
        Map<String, Integer> popularity = new HashMap<>();
        for (String name : students) {
            popularity.put(name, 0);
        }

        for (int i = 0; i < n; i++) {
            String[] likes = br.readLine().split(" ");
            for (String liked : likes) {
                popularity.put(liked, popularity.get(liked) + 1);
            }
        }

        List<String> result = new ArrayList<>(popularity.keySet());
        result.sort((a, b) -> {
            if (!popularity.get(a).equals(popularity.get(b))) {
                return popularity.get(b) - popularity.get(a);
            } else {
                return a.compareTo(b); 
            }
        });

        for (String name : result) {
            System.out.println(name + " " + popularity.get(name));
        }
    }
}
