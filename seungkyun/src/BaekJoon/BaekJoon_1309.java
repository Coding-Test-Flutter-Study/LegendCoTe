import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int [][] DP;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        DP = new int[N+1][3];

        DP[1][0]=1;
        DP[1][1]=1;
        DP[1][2]=1;


        //0에만 잇는 경유 + 1 에만 있는 경우 + 둘다 없는 경우
        for(int i=2; i<=N;i++) {
            DP[i][0] = (DP[i-1][1]+DP[i-1][2])%9901;
            DP[i][1] = (DP[i-1][0]+DP[i-1][2])%9901;
            DP[i][2] = (DP[i-1][1]+DP[i-1][2]+DP[i-1][0])%9901;
        }

        int ans = (DP[N][0]+DP[N][1]+DP[N][2])%9901;

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}