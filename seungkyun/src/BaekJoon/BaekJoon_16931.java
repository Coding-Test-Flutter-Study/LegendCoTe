import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [][] paper;
    static int N,M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans;


    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                int a = Integer.parseInt(st2.nextToken());
                paper[i][j] = a;
            }
        }

        cal();
        bw.write(String.valueOf(ans));

        bw.flush();
    }



    static void cal(){

        ans+=N*M*2;

        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                for(int k = paper[i][j]; k>0;k--){
                    for(int d = 0; d<4;d++){
                        int newI = i+dx[d];
                        int newJ = j+dy[d];

                        if(newI<0||newI>=N){
                            ans++;
                            continue;
                        }
                        if(newJ<0||newJ>=M){
                            ans++;
                            continue;
                        }
                        if(paper[newI][newJ]<k){
                            ans++;
                        }

                    }
                }

            }
        }

    }

}