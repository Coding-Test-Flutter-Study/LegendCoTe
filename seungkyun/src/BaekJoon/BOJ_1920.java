package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static long[] arrayN;


        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arrayN = new long[N];
            for (int i = 0; i < N; i++) {
                long n = Long.parseLong(st.nextToken());
                arrayN[i] = n;
            }
            Arrays.sort(arrayN);

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int m = Integer.parseInt(st2.nextToken());
                bw.write(binary(m, arrayN.length - 1, 0) + "\n");
            }

            bw.flush();
        }

        static int binary(long key, int high, int low) {

            int mid = (low + high) / 2;

            if (low <= high) {
                if (key == arrayN[mid]) {
                    return 1;
                } else if (key < arrayN[mid]) {
                    return binary(key, mid - 1, low);
                } else
                    return binary(key, high, mid + 1);
            } else {
                return 0;
            }
        }


}
