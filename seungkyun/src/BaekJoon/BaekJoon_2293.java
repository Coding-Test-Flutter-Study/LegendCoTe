import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,K;
    static int [] array;
    static long[] DP;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N];

        DP = new long[K+1];

        for(int i=0; i<N;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        DP[0]=1;


        for(int i=0; i<N;i++){

            for(int j= array[i];j<=K;j++){
                DP[j] += DP[j-array[i]];
            }
        }
        bw.write(String.valueOf(DP[K]));
        bw.flush();
    }
}