package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class BOJ_4673 {

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static ArrayList<Integer> arrayList = new ArrayList<>();

        static HashSet<Integer> hashSet = new HashSet<>();

        public static void main(String[] args) throws IOException {


            for (int i = 1; i <= 10000; i++) {
                selfNum(String.valueOf(i));
            }
            for (int i = 1; i <= 10000; i++) {
                if (!hashSet.contains(i)) {
                    bw.write(i + "\n");
                }
            }

            bw.flush();
        }

        static void selfNum(String n) {
            int selfN = Integer.parseInt(n);

            for (int i = 0; i < n.length(); i++) {

                selfN += Integer.parseInt(String.valueOf(n.charAt(i)));
            }

            hashSet.add(selfN);

        }


}
