import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    static int startN,startM;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N;i++){
            StringTokenizer st2 =new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j]==2){
                    startN=i;
                    startM=j;
                }
                if(map[i][j]==1){
                    map[i][j]=-1;
                }
            }
        }
        map[startN][startM]=0;

        bfs();

        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){

                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }


    static void bfs(){

        visited[startN][startM] = true;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startN,startM});

        while (!queue.isEmpty()){

            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i=0; i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<M&&!visited[newX][newY]&&map[newX][newY]==-1){

                    visited[newX][newY]=true;
                    map[newX][newY]=map[x][y]+1;
                    queue.offer(new int[]{newX,newY});


                }
            }


        }

    }



}