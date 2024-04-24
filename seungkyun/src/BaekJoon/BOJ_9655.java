import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int nRest;
    static int nQuo;

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());



        nQuo = N/3;
        nRest = N%3;

        if(nQuo==0){
            if(nRest==1){
                bw.write("SK");
            } else {
                bw.write("CY");
            }
        } else {
            if(nQuo%2==0){
                if(nRest%2==0){
                    bw.write("CY");
                } else {
                    bw.write("SK");
                }
            } else {
                if(nRest%2==0){
                    bw.write("SK");
                } else {
                    bw.write("CY");
                }
            }
        }




        bw.flush();
    }


}