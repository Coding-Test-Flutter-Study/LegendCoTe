package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_1620 {


        static HashMap<String,String> hashMapName= new HashMap<>();
        static HashMap<String,String> hashMapNum= new HashMap<>();

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i=1; i<=N;i++){
                String poketmon = br.readLine();
                hashMapName.put(poketmon,String.valueOf(i));
                hashMapNum.put(String.valueOf(i),poketmon);
            }
            for(int i=1;i<=M;i++){

                String find = br.readLine();
                bw.write(hashMapName.getOrDefault(find,hashMapNum.get(find))+"\n");
            }
            bw.flush();
        }



}
