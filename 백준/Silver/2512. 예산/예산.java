import java.util.Scanner;

public class Main {
    public static int findMaxBudget(int[] requests, int totalBudget) {
        int left = 0;
        int right = 0;
        for (int request : requests) {
            if (request > right) right = request;
        }
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int allocated = 0;
            for (int request : requests) {
                allocated += Math.min(request, mid);
            }

            if (allocated <= totalBudget) {
                answer = mid;  
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] requests = new int[n];

        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }
        int totalBudget = scanner.nextInt();
        scanner.close();

        System.out.println(findMaxBudget(requests, totalBudget));
    }
}
