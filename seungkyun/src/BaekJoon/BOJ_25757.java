import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int N;
    static String game;
    static int ans;
    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        game = st.nextToken();


        for(int i=0; i<N;i++){
            hashSet.add(br.readLine());
        }

        game(game);

        bw.write(String.valueOf(ans));

        bw.flush();
    }


    static void game(String gameName){

        if(gameName.equals("Y")){
            ans = hashSet.size();
        } else if (gameName.equals("F")) {
            ans = hashSet.size()/2;
        } else if (gameName.equals("O")) {
            ans = hashSet.size()/3;
        }
    }


}