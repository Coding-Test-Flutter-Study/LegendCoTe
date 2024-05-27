import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int total;
    static int x1,x2,x3,y1,y2,y3;
    static int road1,road2,road3,between;
    static int[][] array = new int[3][2]; // 마지막 세 좌표를 저장할 배열

    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        array = new int[3][2];
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            array[i%3][0]=x;
            array[i%3][1]=y;

            //0 1 2 0 1 2 0
            if(i>=1){
                total+=(Math.abs(array[(i-1)%3][0]-array[i%3][0])+Math.abs(array[(i-1)%3][1]-array[i%3][1]));
            }

            if(i>=2){
                road1 = Math.abs(array[(i-2)%3][0]-array[(i-1)%3][0])+Math.abs(array[(i-2)%3][1]-array[(i-1)%3][1]);
                road2 = Math.abs(array[(i-1)%3][0]-array[i%3][0])+Math.abs(array[(i-1)%3][1]-array[i%3][1]);
                road3 = Math.abs(array[(i-2)%3][0]-array[i%3][0])+Math.abs(array[(i-2)%3][1]-array[i%3][1]);

                between = Math.max(between,Math.abs((road1+road2)-road3));
            }
        }


        bw.write(String.valueOf(total-between));
        bw.flush();
    }


}
