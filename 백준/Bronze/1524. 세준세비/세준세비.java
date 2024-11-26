import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); 

            while(T-- > 0) {
                br.readLine();
                
                st = new StringTokenizer(br.readLine(), " "); 
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken()); 

                st = new StringTokenizer(br.readLine(), " ");
                PriorityQueue<Integer> sejun = new PriorityQueue<>();
                for (int i = 0; i < N; i++) {
                    sejun.add(Integer.parseInt(st.nextToken()));
                }

                PriorityQueue<Integer> sebi = new PriorityQueue<>();
                st = new StringTokenizer(br.readLine(), " "); 
                for (int i = 0; i < M; i++) {
                    sebi.add(Integer.parseInt(st.nextToken()));
                }

                while (true){

                    if (sejun.isEmpty()){ // size : 1
                        bw.write("B\n");
                        break;
                    }

                    if (sebi.isEmpty()){ // size : 1
                        bw.write("S\n");
                        break;
                    }

                    if(sejun.peek() > sebi.peek()){ 

                        sebi.remove();
                    } else if (sejun.peek().equals(sebi.peek()) ) { 

                        sebi.remove();
                    } else {

                        sejun.remove();
                    }
                }
            }
            bw.flush();


        }

    }