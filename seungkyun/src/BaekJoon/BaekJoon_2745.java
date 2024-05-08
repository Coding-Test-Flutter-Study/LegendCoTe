import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int B;
    static String N;

    static int ans;
    static int b;



    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        B = Integer.parseInt(st.nextToken());

        b=1;

        for(int i=N.length()-1; i>=0;i--){

            if(N.charAt(i)>='A'&&N.charAt(i)<='Z'){
                ans+=(N.charAt(i)-55)*b;
            } else {
                ans+=(N.charAt(i)-'0')*b;
            }

            b*=B;
        }

        bw.write(String.valueOf(ans));

        bw.flush();
    }

}