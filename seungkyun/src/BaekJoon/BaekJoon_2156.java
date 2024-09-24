import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][]DP;
    static int[] wine;
    static int N,ans;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][3];
        wine = new int[N+1];

        for(int i=1; i<=N;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }


        DP[1][1]=wine[1];


        for(int i=2; i<=N;i++){


            DP[i][0] = Math.max(DP[i-1][0],Math.max(DP[i-1][1],DP[i-1][2]));
            DP[i][1] = DP[i-1][0]+ wine[i];
            DP[i][2] = DP[i-1][1] + wine[i];

        }

        for(int i=1; i<=N;i++){
            ans = Math.max(ans,Math.max(DP[i][0],Math.max(DP[i][1],DP[i][2])));
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}