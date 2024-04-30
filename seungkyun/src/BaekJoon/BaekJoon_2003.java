import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N, M;
    static int[] array;
    static int start, end;
    static int ans, sum;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st2.nextToken());

            array[i] = n;
        }

        twoPointer();
        bw.write(String.valueOf(ans));

        bw.flush();
    }


    static void twoPointer() throws IOException {

        start = 0;
        end = 0;

        sum += array[0];


        while (true) {
            if (sum == M) {
                ans++;
                if (end +1< N && start + 1 < N) {
                    end++;
                    sum -= array[start];
                    sum += array[end];
                    start++;
                } else {
                    break;
                }
            } else if (sum < M) {
                if (end+1 < N) {
                    end++;
                    sum += array[end];
                } else {
                    break;
                }

            } else if (sum > M) {
                if (start + 1 < N) {
                    sum -= array[start];
                    start++;
                } else {
                    break;
                }
            }

        }
    }


}