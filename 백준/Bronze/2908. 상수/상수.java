import java.util.Scanner;

public class Main {
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        int reversedA = reverseNumber(Integer.parseInt(A));
        int reversedB = reverseNumber(Integer.parseInt(B));
        
        if (reversedA > reversedB) {
            System.out.println(reversedA);
        } else {
            System.out.println(reversedB);
        }
        
        sc.close();
    }
}
