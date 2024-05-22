import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int mo,ja;
    static int count;
    static int L,C;
    static String[] array;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        array = new String[C];
        visited = new boolean[C];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<C;i++){
            String str = st2.nextToken();
            array[i]=str;
        }

        Arrays.sort(array);

        dfs("",0,0,0,visited,0);
        bw.flush();
    }

    static void dfs(String str,int count, int mo, int ja,boolean[] visited,int I) throws IOException{

        if(count==L){
            if(mo>=1&&ja>=2){

                bw.write(str+"\n");
            }
            return;
        }

        for(int i=I; i<C;i++){

            if(!visited[i]){
                visited[i]=true;
                if (array[i].equals("a") || array[i].equals("e") || array[i].equals("i") || array[i].equals("o") || array[i].equals("u")) {
                    dfs(str+array[i],count+1,mo+1,ja,visited,i);
                } else {
                    dfs(str+array[i],count+1,mo,ja+1,visited,i);
                }
                visited[i]= false;
            }
        }

    }
}