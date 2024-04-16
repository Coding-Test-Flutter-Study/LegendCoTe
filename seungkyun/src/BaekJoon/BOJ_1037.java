package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static int[] array;

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            array = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N;i++){
                int a = Integer.parseInt(st.nextToken());
                array[i]= a;
            }
            Arrays.sort(array);
            if(array.length==1){
                bw.write(String.valueOf(array[0]*array[0]));
            } else {
                bw.write(String.valueOf(array[0]*array[array.length-1]));
            }

            bw.flush();
        }



}
