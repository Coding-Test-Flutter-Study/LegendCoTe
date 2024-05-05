import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int count;
    static String S,T;

    static Queue<String> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        S = br.readLine();
        T = br.readLine();

        check(T);


        if(count>=1){
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
    }

    static void check(String string)  {


        if(string.length()==S.length()){

            if (string.equals(S)){
                count++;
            }

        } else if (string.length()>S.length()) {


            if(string.charAt(string.length()-1)=='A'){
                StringBuilder stringBuilder = new StringBuilder(string);

                String str = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
                check(str);

            }
            if (string.charAt(0)=='B') {
                StringBuilder stringBuilder = new StringBuilder(string);

                String str =stringBuilder.deleteCharAt(0).reverse().toString();
                check(str);

            }
        }



    }



}