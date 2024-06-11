import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M,x1,y1,x2,y2,ans;

    static int[][] map = new int[100][100];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st2.nextToken())-1;
            y1 = Integer.parseInt(st2.nextToken())-1;
            x2 = Integer.parseInt(st2.nextToken())-1;
            y2 = Integer.parseInt(st2.nextToken())-1;

            for(int x=0; x<100;x++){
                for(int y=0 ;y<100;y++){
                    if(x1<=x&&x<=x2&&y1<=y&&y<=y2){
                        map[x][y]++;
                    }
                }
            }

        }

        for(int x=0; x<100;x++){
            for(int y=0 ;y<100;y++){
                if(map[x][y]>M){
                    ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

}