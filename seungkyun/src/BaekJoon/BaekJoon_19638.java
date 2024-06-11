import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long N,H,T,times,H2;

    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<N;i++){
            long h = Integer.parseInt(br.readLine());
            priorityQueue.offer(h);
        }


        check();


        bw.flush();
    }

    static void check() throws IOException {

        for(int i=0; i<T;i++){
            H2 = priorityQueue.poll();

            if(H2<H){
                bw.write("YES"+"\n"+times);
                return;
            }

            if(H2!=1){
                priorityQueue.offer(H2/2);
            } else {
                priorityQueue.offer(H2);
            }
            times++;
        }

        long peek = priorityQueue.peek();
        if(peek>=H){
            bw.write("NO"+"\n"+peek);
        } else {
            bw.write("YES"+"\n"+times);

        }

    }
}