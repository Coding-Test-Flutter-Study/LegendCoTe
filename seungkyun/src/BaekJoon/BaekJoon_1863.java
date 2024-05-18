import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int ans;

    static Stack<Integer> stack = new Stack<>();

    static int n;

    static boolean ok;

    //자기보다 놓으면 스택에 쌓음,
    //낮으면 스택에 없는경우 쌓고 있으면 넘어감

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        stack.push(0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ok = true;

            if (stack.peek() < y) {
                stack.push(y);
            }

            if (stack.peek() > y) {
                while (stack.peek()>y){
                    stack.pop();
                    ans++;
                }


                //같은 높이 없으면 스택에 쌓기
                Iterator<Integer> iterator = stack.iterator();

                while (iterator.hasNext()) {
                    if (iterator.next() == y) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    stack.push(y);
                }

            }

        }

        while (!stack.isEmpty()) {
            stack.pop();
            ans++;
        }

        bw.write(String.valueOf(ans-1));
        bw.flush();
    }


}


