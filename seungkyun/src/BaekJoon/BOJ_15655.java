package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {

        static int N, M;

        static int[] array;
        static int[] ans;

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static boolean[] visited;

        public static void main(String[] args) throws IOException {


            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            visited = new boolean[N];
            array = new int[N];
            ans = new int[M];

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st2.nextToken());
            }

            Arrays.sort(array);

            NM(0, visited, ans,0);
            bw.flush();
        }

        static void NM(int count, boolean[] visited, int[] ans,int I) throws IOException {

            if (count == M) {

                for (int i = 0; i < ans.length; i++) {
                    bw.write(ans[i] + " ");
                }
                bw.write("\n");

                return;
            }

            for (int i = I; i < N; i++) {

                if (!visited[i]) {
                    visited[i] = true;
                    ans[count] = array[i];
                    NM(count + 1, visited, ans,i);
                    visited[i] = false;
                }
            }


        }


}
