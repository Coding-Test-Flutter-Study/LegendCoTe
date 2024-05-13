import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;

    static int [][] map;
    static int x,y;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY= 1;
        int edgeX = N-1;
        int edgeY = N-1;


        int num = N*N;

        if(M==1){
            x=N/2;
            y=N/2;
        }
        while (true){

            while (startX<=edgeX&&num>=1){
                map[startX][startY] = num;
                if(num==M){
                    x = startX;
                    y = startY;
                }
                num--;
                startX++;
            }

            num++;
            startX--;

            while (startY<=edgeY&&num>=1){
                map[startX][startY] = num;
                if(num==M){
                    x = startX;
                    y = startY;
                }
                num--;
                startY++;
            }
            num++;
            startY--;

            while (startX>=endX&&num>=1){
                map[startX][startY] = num;
                if(num==M){
                    x = startX;
                    y = startY;
                }
                num--;
                startX--;
            }
            num++;
            startX++;

            while (startY>=endY&&num>=1){
                map[startX][startY] = num;
                if(num==M){
                    x = startX;
                    y = startY;
                }
                num--;
                startY--;
            }
            startY++;


            startX++;

            endX++;
            endY++;
            edgeX--;
            edgeY--;

            if(num<=1){
                break;
            }

        }


        map[N/2][N/2] = 1;


        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                bw.write(String.valueOf(map[i][j]+" "));
            }
            bw.write("\n");
        }

        bw.write((x+1)+" "+(y+1));




        bw.flush();
    }



}