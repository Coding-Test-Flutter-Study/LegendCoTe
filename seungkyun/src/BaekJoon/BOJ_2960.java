package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2960 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static int[] array;
        static int N,K,count;

        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            count =0;

            array = new int[N+1];

            for(int i=2; i<=N;i++){
                array[i] = i;
            }


            bw.write(String.valueOf(find()));
            bw.flush();
        }

        static int find() throws IOException {
            for(int i=2; i<=N;i++){

                for(int j=2;j<=N;j++){
                    if(array[j]!=0&&array[j]%i==0){
                        count++;
                        if(count==K){
                            return array[j];
                        }
                        array[j]=0;
                    }


                }

            }
            return 0;
        }



}
