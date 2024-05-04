import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [][][] array;
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static int max;
    static Queue<int[]> queue= new LinkedList<>();

    static int M,N,H;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        array = new int[H][N][M];

        for(int h=0; h<H;h++){
            for (int n=0; n<N;n++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int m=0; m<M;m++){
                    int q = Integer.parseInt(st2.nextToken());
                    array[h][n][m]=q;
                    if(q==1){
                        queue.offer(new int []{h,n,m});
                    }
                }
            }
        }

        bfs();
        max = 0;
        for(int h=0; h<H;h++){
            for (int n=0; n<N;n++){
                for(int m=0; m<M;m++){

                    if(array[h][n][m]==0){
                        max = 1000001;
                        break;
                    } else {
                        max = Math.max(max,array[h][n][m]);
                    }
                }
            }
        }

        if(max==1000001){
            bw.write("-1");
        } else {
            bw.write(String.valueOf(max-1));

        }

        bw.flush();
    }

    static void bfs() throws IOException {

        while (!queue.isEmpty()){

            int[] xyz= queue.poll();

            int z = xyz[0];
            int x = xyz[1];
            int y = xyz[2];

            for(int i=0;i<dx.length;i++ ){
                int newX = x+dx[i];
                int newY = y+dy[i];
                int newZ = z+dz[i];

                if(newX>=0&&newY>=0&&newZ>=0&&newX<N&&newY<M&&newZ<H&&array[newZ][newX][newY]==0){

                    queue.offer(new int[]{newZ,newX,newY});
                    array[newZ][newX][newY] = array[z][x][y]+1;
                }
            }
        }
    }
}