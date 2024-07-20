import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비
        
        Map<String, Integer> fruitCount = new HashMap<>();
        fruitCount.put("STRAWBERRY", 0);
        fruitCount.put("BANANA", 0);
        fruitCount.put("LIME", 0);
        fruitCount.put("PLUM", 0);
        
        for (int i = 0; i < N; i++) {
            String card = sc.nextLine();
            String[] parts = card.split(" ");
            String fruit = parts[0];
            int count = Integer.parseInt(parts[1]);
            
            fruitCount.put(fruit, fruitCount.get(fruit) + count);
        }
        
        boolean shouldRingBell = false;
        for (int count : fruitCount.values()) {
            if (count == 5) {
                shouldRingBell = true;
                break;
            }
        }
        
        if (shouldRingBell) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }
}
