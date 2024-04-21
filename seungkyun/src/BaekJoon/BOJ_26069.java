package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_26069 {

        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static int count;
        static HashMap<String,String> hashMap = new HashMap<>();

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if(a.equals("ChongChong")||b.equals("ChongChong")){
                    hashMap.put(a,"Dance");
                    hashMap.put(b,"Dance");
                } else {

                    if(hashMap.getOrDefault(a,"no").equals("Dance")||hashMap.getOrDefault(b,"no").equals("Dance")){
                        hashMap.put(a,"Dance");
                        hashMap.put(b,"Dance");
                    } else {
                        hashMap.put(a,"no");
                        hashMap.put(b,"no");
                    }
                }

            }

            Iterator<String> iterator=  hashMap.values().iterator();

            while(iterator.hasNext()){
                if(iterator.next().equals("Dance")){
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }



}
