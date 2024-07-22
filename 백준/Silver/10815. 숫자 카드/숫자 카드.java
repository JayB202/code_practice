import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

    }
}