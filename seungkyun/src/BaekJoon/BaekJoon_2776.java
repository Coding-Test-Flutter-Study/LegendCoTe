package solve;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int T, N, M;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            HashSet<Integer> hashSet = new HashSet<>();

            N = Integer.parseInt(br.readLine());
            int[] arrayN = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrayN[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrayN);

            M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bw.write(binary(Integer.parseInt(st2.nextToken()), arrayN) + "\n");
            }
        }
        bw.flush();
    }

    static String binary(int now, int[] array) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (now > array[mid]) {
                left = mid + 1;
            } else if (now < array[mid]) {
                right = mid - 1;
            } else {
                return "1";
            }
        }
        return "0";
    }
}
