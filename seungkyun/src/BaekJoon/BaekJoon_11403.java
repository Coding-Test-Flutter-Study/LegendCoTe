import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [][] map;
    static int N;

    static int max = 101;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());


        map = new int[N][N];


        //변수 대입
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==0){
                    map[i][j]=max;
                } else {
                    map[i][j] = a;
                }
            }
        }

        floydWarshall();
        check();
        bw.flush();
    }


    static void floydWarshall(){

        for(int k=0; k<N;k++){
            for(int i=0; i<N;i++){
                for(int j=0; j<N;j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
    }

    static void check() throws IOException{
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                if(map[i][j]!=max){
                    bw.write(1+" ");
                } else {
                    bw.write(0+" ");
                }
            }
            bw.write("\n");
        }

    }


}