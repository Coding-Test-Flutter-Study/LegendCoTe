import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map = new int[5][5];

    static int bingo;
    static int ans;



    public static void main(String[] args) throws IOException {


        for(int i=0; i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5;j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }

        for(int i=0; i<5;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<5;j++){
                int n = Integer.parseInt(st2.nextToken());
                ans++;

                check(n);

                if(bingo>=3){
                    break;
                }
                bingo=0;
            }
            if(bingo>=3){
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }


    static void check(int n){

        for(int i=0; i<5;i++){
            for(int j=0; j<5;j++){
                if(map[i][j]==n){
                    map[i][j] = 0;
                    break;
                }
            }
        }

        for(int i=0; i<5;i++){
            if(map[i][0]==0&&map[i][1]==0&&map[i][2]==0&&map[i][3]==0&&map[i][4]==0){
                bingo++;
            }
        }

        for(int i=0; i<5;i++){
            if(map[0][i]==0&&map[1][i]==0&&map[2][i]==0&&map[3][i]==0&&map[4][i]==0){
                bingo++;
            }
        }

        int c = 0;
        for(int i=0; i<5;i++){
            if(map[i][i] == 0){
                c++;
            }
        }
        if(c==5){
            bingo++;
        }

        int d = 0;
        for(int i=0; i<5;i++){
            if(map[i][4-i] == 0){
                d++;
            }
        }
        if(d==5){
            bingo++;
        }

    }



}