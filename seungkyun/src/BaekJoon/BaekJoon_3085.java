import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    //행, 열 최대 체크

    static int N;
    static String [][] map;
    static String [][] newMap;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans;
    static int eat;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        newMap = new String[N][N];

        for(int i=0; i<N;i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j=0; j<strings.length;j++){
                map[i][j] = strings[j];
            }
        }


        eat(map);

        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                change(i,j);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
    static void change(int x, int y) throws IOException {


        for(int i=0; i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            copyMap(map,newMap);

            if(newX>=0&&newY>=0&&newX<N&&newY<N&&!map[x][y].equals(map[newX][newY])){

                newMap[x][y] = map[newX][newY];
                newMap[newX][newY] = map[x][y];

                eat(newMap);
            }
        }

    }

    static void eat(String[][] newMaps) throws IOException {
        eat =1;
        for(int i=0; i<N;i++){
            for(int j=1; j<N;j++){

                if(newMaps[i][j].equals(newMaps[i][j-1])){
                    eat++;
                } else {
                    eat = 1;
                }
                ans = Math.max(ans,eat);
            }
            eat=1;
        }

        for(int j=0; j<N;j++){
            for(int i=1; i<N;i++){
                if(newMaps[i][j].equals(newMaps[i-1][j])){
                    eat++;
                } else {
                    eat = 1;
                }
                ans = Math.max(ans,eat);
            }
            eat=1;
        }
    }

    static void copyMap(String[][] map, String[][] newMap){
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                newMap[i][j]=map[i][j];
            }
        }
    }

}


