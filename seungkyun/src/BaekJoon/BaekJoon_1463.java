import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [] DP;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1];

        DP[N]=0;

        for(int i= N;i>=1;i--){



            if(i%3==0){
                if(DP[i/3]==0){
                    DP[i/3]=DP[i]+1;
                } else {
                    DP[i/3]=Math.min(DP[i/3],DP[i]+1);
                }
            }

            if(i%2==0){
                if(DP[i/2]==0){
                    DP[i/2]=DP[i]+1;
                } else {
                    DP[i/2]=Math.min(DP[i/2],DP[i]+1);
                }
            }

            if(DP[i-1]==0){
                DP[i-1]=DP[i]+1;
            } else {
                DP[i-1]=Math.min(DP[i-1],DP[i]+1);
            }
        }
        bw.write(String.valueOf(DP[1]));
        bw.flush();
    }



}