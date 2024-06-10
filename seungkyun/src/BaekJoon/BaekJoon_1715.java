import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,n,a,b,ans;

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N;i++){
            n = Integer.parseInt(br.readLine());
            priorityQueue.offer(n);
        }

        if(N==1){
            ans =0;
        } else {
            while (priorityQueue.size()!=1){
                a = priorityQueue.poll();
                b = priorityQueue.poll();
                int sum = a+b;
                ans+=sum;
                priorityQueue.offer(sum);
            }

        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}