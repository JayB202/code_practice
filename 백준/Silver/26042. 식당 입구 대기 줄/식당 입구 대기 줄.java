import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Initialize the queue to keep track of students waiting
        Queue<Integer> queue = new LinkedList<>();
        // Variables to track maximum waiting students and the student number at that moment
        int maxWaiting = 0;
        int studentAtMaxWaiting = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("1")) {
                // Student arrives
                int studentNumber = Integer.parseInt(input[1]);
                queue.offer(studentNumber);
                // Update max waiting students and the student number at the back if necessary
                if (queue.size() > maxWaiting) {
                    maxWaiting = queue.size();
                    studentAtMaxWaiting = studentNumber;
                } else if (queue.size() == maxWaiting) {
                    studentAtMaxWaiting = Math.min(studentAtMaxWaiting, studentNumber);
                }
            } else if (input[0].equals("2")) {
                // Meal is ready
                if (!queue.isEmpty()) {
                    queue.poll();  // Student at the front starts eating
                }
            }
        }

        // Print the result
        System.out.println(maxWaiting + " " + studentAtMaxWaiting);
    }
}
