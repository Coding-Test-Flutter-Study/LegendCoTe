import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static boolean[][] visited;
    static String[][] map;
    static boolean ok;
    static int N,M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int startX,startY;


    public static void main(String[] args) throws IOException {

        ok = false;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N;i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j=0; j<M;j++){
                map[i][j] = strings[j];
            }
        }

        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(!visited[i][j]){
                    visited = new boolean[N][M];
                    startX=i;
                    startY=j;
                    dfs(i,j,visited,1,map[i][j]);
                    if(ok){
                        break;
                    }
                }
            }
            if(ok){
                break;
            }
        }



        if(ok){
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        bw.flush();
    }

    static void dfs(int x,int y, boolean[][] visited, int count,String str){

        if(startX==x&&startY==y&&count>=4){
            ok=true;
            return;
        }
        for(int i=0; i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(newX>=0&&newY>=0&&newX<N&&newY<M&&!visited[newX][newY]&&map[newX][newY].equals(str)){
                visited[newX][newY]=true;
                dfs(newX,newY,visited,count+1,str);
                visited[newX][newY]=false;
            }
        }

    }


}