import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long [] DP;
    static int [] array;
    static int N;
    static long ans;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        DP = new long[N+1];
        array = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N;i++){
            array[i]= Integer.parseInt(st.nextToken());
        }

        ans = array[1];
        for(int i=1; i<=N;i++){

            DP[i]= Math.max(DP[i-1]+array[i],array[i]);
            ans = Math.max(ans,DP[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}