package BaekJoon;

import java.io.*;

public class BaekJoon_2444 {

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N;i++){
                for(int j=1; j<=N-i;j++){
                    bw.write(" ");
                }
                for(int k=1;k<=2*i-1;k++){
                    bw.write("*");
                }
                bw.write("\n");
            }

            for(int i=1; i<=N-1;i++){

                for(int j=0;j<i;j++){
                    bw.write(" ");
                }
                for(int j=2*N-1-2*i;j>=1;j-- ){
                    bw.write("*");
                }
                if(i<N-1){
                    bw.write("\n");

                }
            }

            bw.flush();
        }



}
