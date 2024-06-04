import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String str1 ;
    static String str2 ;
    static String newStr1="" ;
    static String newStr2="" ;



    public static void main(String[] args) throws IOException {

        str1 = br.readLine();
        str2 = br.readLine();

        int l = str1.length()*str2.length();

        while (true){
            newStr1 +=str1;
            if (newStr1.length()==l){
                break;
            }
        }

        while (true){
            newStr2 +=str2;
            if (newStr2.length()==l){
                break;
            }
        }
        if(newStr2.equals(newStr1)){
            bw.write("1");
        } else{
            bw.write("0");
        }
        bw.flush();
    }





}