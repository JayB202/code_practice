import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        String[] words = input.trim().split("\\s+");
        
        // 단어 배열의 길이를 출력
        if (words.length == 1 && words[0].isEmpty()) {
            // 입력이 공백만으로 이루어져 있는 경우 0
            System.out.println(0);
        } else {
            System.out.println(words.length);
        }
        
        sc.close();
    }
}
