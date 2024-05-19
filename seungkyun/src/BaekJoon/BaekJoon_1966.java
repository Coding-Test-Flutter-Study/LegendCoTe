import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    // 알고자 하는 수 0으로 바꿈
    // 큐 돌면서 자기보다 큰 값 확인
    //없으면 출력 있으면 poll offer

    static int testCase;
    static int order,priority;
    static int N, M;
    static int ans;
    static boolean ok;

    public static void main(String[] args) throws IOException {

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            Queue<int[]> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st2.nextToken());
                queue.offer(new int[]{j, a});
            }

            //체크
            while (!queue.isEmpty()) {

                ok = false;
                int[] array = queue.peek();


                order = array[0];
                priority = array[1];

                Iterator<int[]> iterator = queue.iterator();

                while (iterator.hasNext()) {

                    if (priority < iterator.next()[1]) {
                        queue.offer(queue.poll());
                        ok = false;
                        break;
                    }
                    ok = true;
                }

                if (ok) {
                    ans++;
                    queue.poll();
                    if (M == order) {
                        bw.write(String.valueOf(ans) + "\n");
                        break;
                    }
                }
            }
            ans=0;

        }

        bw.flush();
    }


}