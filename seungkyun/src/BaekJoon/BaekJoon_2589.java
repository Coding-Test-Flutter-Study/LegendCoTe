import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //L마다 bfs로 거리 측정, 최종 지도 탐색

    static int X,Y;
    static String[][] map;
    static String[][] newMap;

    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new String[X][Y];
        newMap = new String[X][Y];
        visited= new boolean[X][Y];

        for(int i=0; i<X;i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j=0; j<Y;j++){
                map[i][j]=strings[j];
            }
        }

        for(int i=0; i<X;i++){
            for(int j=0; j<Y;j++){
                if(map[i][j].equals("L")){
                    bfs(i,j);
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void bfs(int x, int y){
        visited= new boolean[X][Y];

        copyMap(map,newMap);
        newMap[x][y]= "0";

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        visited[x][y]=true;

        while (!queue.isEmpty()){
            int[] xy = queue.poll();

            for(int i=0; i<4;i++){

                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<X&&newY<Y&&!visited[newX][newY]&&newMap[newX][newY].equals("L")){
                    visited[newX][newY]=true;
                    newMap[newX][newY]=String.valueOf(Integer.parseInt(newMap[xy[0]][xy[1]])+1);
                    ans = Math.max(ans,Integer.parseInt(newMap[newX][newY]));
                    queue.offer(new int[]{newX,newY});
                }
            }
        }


    }


    static void copyMap(String[][] map, String[][]newMap) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
}