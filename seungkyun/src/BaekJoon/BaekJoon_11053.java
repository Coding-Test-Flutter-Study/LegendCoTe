import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [] DP,array;
    static int N;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());

        DP = new int[N+1];
        array = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N;i++){
            array[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N;i++){
            DP[i]=1;
        }



        for(int i=2; i<=N;i++){


            if(array[i]>array[i-1]){
                DP[i]=DP[i-1]+1;
            }
            for(int j=1; j<i;j++){
                if(array[i]>array[j]&&DP[j]+1>DP[i]){

                    DP[i] = DP[j]+1;
                }
            }

        }
        int max =0;
        for(int i=1; i<=N;i++){
            max = Math.max(max,DP[i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}