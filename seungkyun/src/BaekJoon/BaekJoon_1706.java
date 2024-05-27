import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String[][]map;
    static boolean [][] visited1;
    static boolean [][] visited2;

    static int R,C;
    static String ans;
    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visited1 = new boolean[R][C];
        visited2 = new boolean[R][C];


        for(int i=0; i<R;i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j=0; j<C;j++){
                map[i][j]=strings[j];
            }
        }


        for(int i=0; i<R;i++){

            for(int j=0; j<C;j++){
                if(!visited1[i][j]&&!map[i][j].equals("#")){
                    checkX(i,j);
                }
                if(!visited2[i][j]&&!map[i][j].equals("#")){
                    checkY(i,j);
                }
            }
        }

        Collections.sort(arrayList);
//        bw.write(String.valueOf(arrayList));
        bw.write(arrayList.get(0));

        bw.flush();
    }

    static void checkX(int x,int y){
        visited1[x][y]=true;
        String string =map[x][y];
        int i=1;
        while (true){

            if((x+i)<R&&!visited1[x+i][y]&&!map[x+i][y].equals("#")){
                string=string+map[x+i][y];
                visited1[x+i][y]=true;
                i++;
            } else {
                break;
            }
        }

        if(string.length()>=2){
            arrayList.add(string);
        }
    }

    static void checkY(int x,int y){
        visited2[x][y]=true;
        String string =map[x][y];
        int i=1;
        while (true){

            if((y+i)<C&&!visited2[x][y+i]&&!map[x][y+i].equals("#")){
                string=string+map[x][y+i];
                visited2[x][y+i]=true;
                i++;
            } else {
                break;
            }
        }

        if(string.length()>=2){
            arrayList.add(string);
        }
    }

}