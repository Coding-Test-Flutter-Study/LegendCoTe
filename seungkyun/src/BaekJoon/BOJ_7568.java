import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        int [][] array = new int[N][2];

        for(int i=0; i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            array[i][0]=weight;
            array[i][1]=height;
        }





        bw.flush();
    }
}