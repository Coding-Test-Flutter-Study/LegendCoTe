import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int H,W,N,M;
    static int count;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        for(int i=0; i<H;i++){
            for(int j=0; j<W;j++){

                if((N+1)*i<H&&(M+1)*j<W){

                    count++;
                }

            }
        }




        bw.write(String.valueOf(count));
        bw.flush();
    }




}