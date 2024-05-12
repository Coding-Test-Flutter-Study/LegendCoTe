import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String S,T;

    static int ok;

    public static void main(String[] args) throws IOException {

        S = br.readLine();
        T = br.readLine();

        check(T);


        bw.write(String.valueOf(ok));
        bw.flush();
    }


    static void check(String string) {

        if(string.equals(S)){
            ok =1;
            return;
        }

        if(!string.isEmpty()){

            StringBuilder sb = new StringBuilder(string);

            if(string.charAt(string.length()-1)=='A'){
                String str= sb.deleteCharAt(string.length()-1).toString();
                check(str);
            }

            if(string.charAt(string.length()-1)=='B'){
                String str= sb.deleteCharAt(string.length()-1).reverse().toString();
                check(str);
            }
        }
    }


}