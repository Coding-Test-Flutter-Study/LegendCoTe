package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14888 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static long[] array;
        static int[] calculate;

        static ArrayList<Long> arrayList = new ArrayList<>();


        public static void main(String[] args) throws IOException {


            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            array = new long[N];
            for (int i = 0; i < N; i++) {
                long n = Long.parseLong(st.nextToken());
                array[i] = n;
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            calculate = new int[4];
            for (int i = 0; i < 4; i++) {
                int a = Integer.parseInt(st2.nextToken());
                calculate[i] = a;
            }

            find(1, array[0], calculate);

            Collections.sort(arrayList);
            bw.write(arrayList.get(arrayList.size() - 1) + "\n" + arrayList.get(0));

            bw.flush();
        }

        static void find(int count, long ans, int[] cal) {
            if (count == array.length) {
                arrayList.add(ans);
            }

            if (count < array.length) {
                for (int i = 0; i < 4; i++) {
                    if (i == 0 && calculate[0] != 0) {
                        calculate[0] -= 1;
                        find(count + 1, ans + array[count], calculate);
                        calculate[0] += 1;
                    } else if (i == 1 && calculate[1] != 0) {
                        calculate[1] -= 1;
                        find(count + 1, ans - array[count], calculate);
                        calculate[1] += 1;
                    } else if (i == 2 && calculate[2] != 0) {
                        calculate[2] -= 1;
                        find(count + 1, ans * array[count], calculate);
                        calculate[2] += 1;
                    } else if (i == 3 && calculate[3] != 0) {
                        calculate[3] -= 1;
                        find(count + 1, ans / array[count], calculate);
                        calculate[3] += 1;

                    }
                }

            }

        }

}
