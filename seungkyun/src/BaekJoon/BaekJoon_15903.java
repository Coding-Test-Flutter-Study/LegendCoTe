import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long n,m,x,y,sum,ans;

    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer st2= new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            long a = Integer.parseInt(st2.nextToken());
            priorityQueue.offer(a);
        }

        for(int i=0; i<m;i++){
            x = priorityQueue.poll();
            y = priorityQueue.poll();
            sum = x+y;
            priorityQueue.offer(sum);
            priorityQueue.offer(sum);
        }

        Iterator<Long> iterator = priorityQueue.iterator();

        while (iterator.hasNext()){
            ans+=iterator.next();
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}