import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] DP,price;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1][3];
        price = new int[N+1][3];

        for(int i=1; i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0]=Integer.parseInt(st.nextToken());
            price[i][1]=Integer.parseInt(st.nextToken());
            price[i][2]=Integer.parseInt(st.nextToken());
        }

        DP[0][0]=0;
        DP[0][1]=0;
        DP[0][2]=0;

        for(int i=1; i<=N;i++){

            DP[i][0]=Math.min(DP[i-1][1],DP[i-1][2])+price[i][0];
            DP[i][1]=Math.min(DP[i-1][0],DP[i-1][2])+price[i][1];
            DP[i][2]=Math.min(DP[i-1][1],DP[i-1][0])+price[i][2];

        }
        bw.write(String.valueOf(Math.min(DP[N][0],Math.min(DP[N][1],DP[N][2]))));

        bw.flush();
    }

}