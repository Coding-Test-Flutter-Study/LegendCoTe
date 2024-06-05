import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int N,M;
    static HashSet<String> memo = new HashSet<>();


    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        for(int i=0; i<N;i++){
            String str =br.readLine();
            memo.add(str);
        }

        for(int i=0; i<M;i++){
            String str = br.readLine();
            String[] strings = str.split(",");

            for(int j=0; j< strings.length;j++){
                memo.remove(strings[j]);
            }
            bw.write(String.valueOf(memo.size())+"\n");
        }
        bw.flush();
    }
}