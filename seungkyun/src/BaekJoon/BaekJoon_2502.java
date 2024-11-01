import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static  int[] DP;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int i=M-1; i>0;i--){
            DP = new int[N+1];
            DP[N] = M;
            DP[N-1] = i;
            for(int day = N-2; day>=1;day--){

                DP[day] = DP[day+2]-DP[day+1];
                if(DP[day]<0){
                    break;
                }


            }

            if(DP[1]>0&&DP[2]>0){
                if(DP[1]<=DP[2]){
                    break;
                }
            }
        }

        bw.write(DP[1]+"\n"+DP[2]);

        bw.flush();
    }
}