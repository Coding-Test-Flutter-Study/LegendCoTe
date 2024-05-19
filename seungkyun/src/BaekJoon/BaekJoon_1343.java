import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String str;
    static boolean ok;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        str = br.readLine();

        int countX=0;

        ok = true;
        for(int i=0; i<str.length();i++){

            if (str.charAt(i)=='.'){

                check(countX);
                sb.append(".");
                countX=0;

            } else {
                countX++;
            }

        }

        check(countX);

        if(ok){
            bw.write(sb.toString());
        } else {
            bw.write("-1");
        }

        bw.flush();
    }


    static void check(int countX){
        while (countX>=4){
            sb.append("AAAA");
            countX-=4;
        }

        if(countX==2){
            sb.append("BB");
        } else if(countX==1||countX==3){
            ok = false;
        }
    }
}