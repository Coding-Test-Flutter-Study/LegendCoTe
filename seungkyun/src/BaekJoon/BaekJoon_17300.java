import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String ans;
    static boolean[] visited = new boolean[10];
    static int[] array;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        pattern();
        bw.write(ans);
        bw.flush();
    }


    static void pattern(){

        for(int i=0; i< array.length-1;i++){

            int now = array[i];
            int next = array[i+1];

            if(now==1){
                visited[now]=true;
                if(next==3&&!visited[next]&&visited[2]||next==7&&!visited[next]&&visited[4]||next==9&&!visited[next]&&visited[5]){
                    ans="YES";
                }  else if(next!=3&&next!=7&&next!=9&&next!=now&&!visited[next]){
                    ans="YES";
                }else {
                    ans = "NO";
                    return;
                }
            } else if(now==2){
                visited[now]=true;
                if(next==8&&!visited[next]&&visited[5]){
                    ans="YES";
                }  else if(next!=8&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==3){
                visited[now]=true;
                if(next==1&&!visited[next]&&visited[2]||next==7&&!visited[next]&&visited[5]||next==9&&!visited[next]&&visited[6]){
                    ans="YES";
                }  else if(next!=1&&next!=7&&next!=9&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==4){
                visited[now]=true;
                if(next==6&&!visited[next]&&visited[5]){
                    ans="YES";
                }  else if(next!=6&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==5){
                visited[now]=true;
                if(next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==6){
                visited[now]=true;
                if(next==4&&!visited[next]&&visited[5]){
                    ans="YES";
                }  else if(next!=4&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==7){
                visited[now]=true;
                if(next==1&&!visited[next]&&visited[4]||next==3&&!visited[next]&&visited[5]||next==9&&!visited[next]&&visited[8]){
                    ans="YES";
                }  else if(next!=1&&next!=3&&next!=9&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==8){
                visited[now]=true;
                if(next==2&&!visited[next]&&visited[5]){
                    ans="YES";
                }  else if(next!=2&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }else if(now==9){
                visited[now]=true;
                if(next==1&&!visited[next]&&visited[5]||next==3&&!visited[next]&&visited[6]||next==7&&!visited[next]&&visited[8]){
                    ans="YES";
                }  else if(next!=1&&next!=3&&next!=7&&next!=now&&!visited[next]){
                    ans="YES";
                }
                else {
                    ans = "NO";
                    return;
                }
            }

        }
    }


}