import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int a;
    static int ans;
    static int count;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                a = Integer.parseInt(st.nextToken());
                priorityQueue.offer(a);
            }
        }

        while (count!=N){
            ans = priorityQueue.poll();
            count++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }


}
