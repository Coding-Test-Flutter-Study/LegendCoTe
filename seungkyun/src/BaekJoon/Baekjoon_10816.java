package BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_10816 {
    static HashSet<Integer> hashSet = new HashSet<>();

    static long[] times = new long[20000005];

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            hashSet.add(n);
            if(n>=0){
                times[n]++;
            } else {
                times[10000000-n]++;
            }

        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<M;i++){
            int m = Integer.parseInt(st2.nextToken());

            if(hashSet.contains(m)){
                if (m>=0){
                    bw.write(times[m]+" ");

                } else {
                    bw.write(times[10000000-m]+" ");

                }
            } else {
                bw.write("0"+" ");
            }
        }
        bw.flush();
    }
}
