import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, ans;
    static int[] array;

    static int left = 0;
    static int right = 1000000000;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }


        binarySearch(left, right);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void binarySearch(int left, int right) {

        int height = (left + right) / 2;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int length = (array[i] - height);
            if (length >= 0) {
                sum += length;
            }
        }


        if (left <= right) {

            if (sum < M) {
                binarySearch(left, height - 1);
            } else {
                ans = height;
                binarySearch(height + 1, right);
            }

        }
    }
}