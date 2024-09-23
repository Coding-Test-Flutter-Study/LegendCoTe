import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [][] DP;
    static int [] stairs;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        DP = new int[N+3][3];
        stairs = new int[N+3];

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            stairs[i+1]=n;
        }

        DP[1][1]=stairs[1];

        for(int i=2; i<=N;i++){


            DP[i][1]= Math.max(DP[i-2][1],DP[i-2][2]) + stairs[i];

            DP[i][2]=DP[i-1][1]+stairs[i];


        }

        bw.write(String.valueOf(Math.max(DP[N][1],DP[N][2])));
        bw.flush();
    }



}