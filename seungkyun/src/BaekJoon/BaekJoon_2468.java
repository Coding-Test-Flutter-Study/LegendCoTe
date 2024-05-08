import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    static int rainMax;
    static int safeArea;
    static int ans;

    public static void main(String[] args) throws IOException {

        //비 max 저장
        //0~max 까지 반복문
        // 방문하지 않은지점 체크하며 bfs, 안전지역 count++, max 체크

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j=0; j<N;j++){
                int a = Integer.parseInt(st2.nextToken());
                map[i][j]=a;
                rainMax = Math.max(rainMax,a);
            }
        }

        for(int rain=0; rain<=rainMax;rain++){

            boolean[][] visited = new boolean[N][N];

            for(int i=0 ;i<N;i++){
                for(int j=0; j<N;j++){

                    if(!visited[i][j]&&map[i][j]>rain){
                        bfs(i,j,visited,rain);
                        safeArea++;
                    }

                }
            }

            ans = Math.max(safeArea,ans);
            safeArea=0;
        }


        bw.write(String.valueOf(ans));

        bw.flush();
    }

    static void bfs(int x, int y,boolean[][] visited,int rain){

        visited[x][y]= true;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] xy = queue.poll();

            for(int i=0; i<4;i++){

                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<N&&!visited[newX][newY]&&map[newX][newY]>rain){

                    visited[newX][newY]= true;
                    queue.offer(new int[]{newX,newY});

                }
            }

        }

    }



}