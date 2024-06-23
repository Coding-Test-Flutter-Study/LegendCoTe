import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int ans;

    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st2.nextToken());
                if (a == 1) {
                    map[i][j] = 1000;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    map[i][j] = a;
                }
            }
        }


        bfs();
        findMax();
        bw.write(String.valueOf(ans-1000));

        bw.flush();
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            for(int i=0; i<8;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<M&&!visited[newX][newY]&&map[newX][newY]==0){
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY]=true;
                    map[newX][newY]=map[xy[0]][xy[1]]+1;
                }
            }
        }
    }

    static void findMax(){
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                int a = map[i][j];

                if(a!=1000){
                    ans = Math.max(a,ans);
                }
            }
        }
    }
}