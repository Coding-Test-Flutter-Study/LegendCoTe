package BaekJoon;

import java.io.*;
import java.util.HashSet;

public class BOJ_25192 {

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static HashSet<String> hashSet = new HashSet<>();

        static int count;
        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N;i++){
                String str = br.readLine();
                if(str.equals("ENTER")){
                    count+= hashSet.size();
                    hashSet.clear();
                } else {
                    hashSet.add(str);
                }

            }

            count += hashSet.size();

            bw.write(String.valueOf(count));
            bw.flush();
        }



}
