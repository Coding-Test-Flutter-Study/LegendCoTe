package BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon_1269 {



        static HashSet<Integer> hashSetA= new HashSet<>();
        static HashSet<Integer> hashSetB= new HashSet<>();


        static int[] arrayA;
        static int[] arrayB;

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arrayA = new int[A];
            arrayB = new int[B];

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i=0; i<A;i++){
                int a = Integer.parseInt(st2.nextToken());
                hashSetA.add(a);
                arrayA[i] = a;
            }

            StringTokenizer st3 = new StringTokenizer(br.readLine());

            for(int i=0; i<B;i++){
                int b = Integer.parseInt(st3.nextToken());
                hashSetB.add(b);
                arrayB[i] = b;
            }

            for (int j : arrayA) {
                hashSetB.remove(j);
            }
            for (int j : arrayB) {
                hashSetA.remove(j);
            }

            bw.write(String.valueOf(hashSetA.size()+hashSetB.size()));
            bw.flush();
        }
}
