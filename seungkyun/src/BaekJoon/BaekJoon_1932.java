import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] DP;
    static int[] array;
    static int N,max;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());

        DP = new int[N+1][N+1];


        for(int i=1; i<=N;i++){
            array = new int[i];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<i;j++){
                array[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0; j<i;j++){

                if(j==0){
                    DP[i][j] = DP[i-1][j]+array[j];
                } else if(j==i-1) {
                    DP[i][j] = DP[i-1][j-1]+array[j];
                } else {
                    DP[i][j] = Math.max(DP[i-1][j-1],DP[i-1][j])+array[j];

                }

            }

        }

        for(int j=0; j<N;j++){
            max = Math.max(max,DP[N][j]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}