package solve;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static int[] DP, array;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        array = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;
        }
        DP[1] = array[1];

        for (int i = 1; i <= N; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    DP[i] = Math.max(DP[j] + array[i], DP[i]);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, DP[i]);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
