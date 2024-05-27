import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static boolean exist;
    static long ans;
    static long A,B;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(0,A);

        if (exist){
            bw.write(String.valueOf(ans+1));
        } else {
            bw.write("-1");
        }
        bw.flush();
    }


    static void dfs(long count,long num){

        if(num>B){
            return;
        }
        if(num==B){
            exist=true;
            ans=count;
            return;
        }

        dfs(count+1,num*2);
        dfs(count+1,num*10+1);

    }
}
