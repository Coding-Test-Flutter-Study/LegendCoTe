import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static String n;

    static int ans;



    public static void main(String[] args) throws IOException {

        n = br.readLine();

        int N = Integer.parseInt(n);

        for(int i=1; i<=N;i++){

            if(i<100){
                ans++;
            } else if (i<1000) {


                int i3 = i/100;
                int i2 = (i%100)/10;
                int i1 = (i%100)%10;

                if(i1-i2 == i2-i3 ){
                    ans++;
                }

            }
        }



        bw.write(String.valueOf(ans));
        bw.flush();
    }



}