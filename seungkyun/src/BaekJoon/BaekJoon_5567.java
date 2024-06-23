import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    static int ans;

    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph= new boolean[N][N];
        visited = new boolean[N];

        for(int i=0; i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            graph[a][b]=graph[b][a]=true;
        }

        queue.offer(new int[]{0,0});
        visited[0]=true;

        while (!queue.isEmpty()){
            int[] a = queue.poll();

            int num = a[0];
            int times = a[1];
            for(int i=1; i<N;i++){
                if(graph[num][i]&&!visited[i]&&times<2){
                    queue.offer(new int[]{i,times+1});
                    visited[i]=true;
                    ans++;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }


}