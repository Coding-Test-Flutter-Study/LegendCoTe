package solve;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static int[] DP,track;
    static String ans;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1];

        track = new int[N+1];
        for(int i=0; i<=N;i++){
            DP[i]=Integer.MAX_VALUE;
        }

        DP[N]=0;

        for(int i=N;i>=1;i--){
            if(DP[i]!=Integer.MAX_VALUE){

                if(i%3==0){

                    if(DP[i/3]>DP[i]+1){
                        DP[i/3] = DP[i]+1;
                        track[i/3]=i;
                    }
                }

                if(i%2==0){

                    if(DP[i/2]>DP[i]+1){
                        DP[i/2] = DP[i]+1;
                        track[i/2]=i;
                    }
                }
                if(DP[i-1]>DP[i]+1){
                    DP[i-1] = DP[i]+1;
                    track[i-1]=i;
                }
            }
        }


        int now =1;
        ans ="";
        while(now!=N){
            ans=now+" "+ans ;
            now = track[now];
        }

        ans=String.valueOf(N)+" "+ans;

        bw.write(DP[1]+"\n"+ans);
        bw.flush();
    }
}
