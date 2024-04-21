package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2644 {


        static int ans;
        static boolean[] visited;
        static int[][] graph;


        static int x,y;
        static int N,M;
        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());

            visited = new boolean[N+1];
            graph = new int[N+1][N+1];

            for(int i=0; i<M;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                graph[a][b]=graph[b][a]=1;

            }


            dfs(x,visited,0);
            if(ans==0){
                bw.write("-1");
            } else {
                bw.write(String.valueOf(ans));

            }

            bw.flush();
        }

        static void dfs(int l ,boolean[] visited,int count) throws IOException {

            if(l==y){
                ans = count;
            } else {
                visited[l]= true;

                for(int i=1;i<=N;i++){
                    if(!visited[i]&&graph[l][i]!=0){
                        visited[i] = true;
                        dfs(i,visited,count+1);
                        visited[i] = false;

                    }
                }
            }


        }



}
