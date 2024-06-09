import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, c, w, ans;

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            c = Integer.parseInt(st2.nextToken());
            priorityQueue.offer(c);
        }

        check();

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void check() throws IOException {

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            w = Integer.parseInt(st3.nextToken());

            c = priorityQueue.peek();
            if (c < w) {
                ans = 0;
                return;
            } else {
                ans = 1;
                priorityQueue.offer(priorityQueue.poll() - w);
            }
        }
    }


}