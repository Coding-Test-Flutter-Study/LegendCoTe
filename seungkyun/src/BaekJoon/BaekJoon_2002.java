import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static ArrayList<String> in = new ArrayList<>();
    static ArrayList<String> out = new ArrayList<>();

    static int T;
    static int ans;
    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T;i++){
            String str = br.readLine();
            in.add(str);
        }

        for(int i=0; i<T;i++){
            String str = br.readLine();
            out.add(str);
        }


        for(int i=0; i<T;i++){

            String inStr = in.get(0);
            String outStr = out.get(0);

            if(inStr.equals(outStr)){
                in.remove(inStr);
                out.remove(outStr);
            } else {
                in.remove(outStr);
                out.remove(outStr);
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}