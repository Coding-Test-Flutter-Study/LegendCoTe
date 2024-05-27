import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int ans1,ans2;
    static String[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;



    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];


        for(int i=0; i<N;i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j=0; j<N;j++){
                map[i][j]=strings[j];
            }
        }

        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                if(!visited1[i][j]){
                    bfs1(i,j,map[i][j]);
                }
                if(!visited2[i][j]){
                    bfs2(i,j,map[i][j]);
                }
            }
        }

        bw.write(ans1+" "+ans2);


        bw.flush();
    }

    static void bfs1(int x, int y,String color){
        Queue<int[]> queue = new LinkedList<>();
        visited1[x][y]=true;
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){

            int[] xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<N&&!visited1[newX][newY]&&map[newX][newY].equals(color)){
                    visited1[newX][newY]=true;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        ans1++;
    }

    static void bfs2(int x, int y,String color){
        Queue<int[]> queue = new LinkedList<>();
        visited2[x][y]=true;
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){

            int[] xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<N&&!visited2[newX][newY]){
                    if(color.equals("R")||color.equals("G")){
                        if(map[newX][newY].equals("R")||map[newX][newY].equals("G")){
                            visited2[newX][newY]=true;
                            queue.offer(new int[]{newX,newY});
                        }
                    } else {
                        if(map[newX][newY].equals(color)){
                            visited2[newX][newY]=true;
                            queue.offer(new int[]{newX,newY});
                        }
                    }
                }
            }
        }
        ans2++;
    }

}
