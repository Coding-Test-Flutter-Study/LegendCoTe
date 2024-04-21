package BaekJoon;

import java.io.*;
import java.util.HashSet;

public class BaekJoon_11478 {


        static HashSet<String> hashSet= new HashSet<>();

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            String str = br.readLine();

            for(int i=0; i<=str.length();i++){
                for(int j=0; j<=str.length()-i;j++){
                    hashSet.add(str.substring(j,j+i));
                }
            }

            bw.write(String.valueOf(hashSet.size()-1));
            bw.flush();
        }

}
