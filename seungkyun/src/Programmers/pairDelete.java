import java.util.*;

class Solution
{

    static Stack<String> stack = new Stack<>();

    public int solution(String s)
    {
        String[] array = s.split("");

        stack.push(array[0]);

        for(int i=1; i<array.length;i++){

            if(stack.isEmpty()){
                stack.push(array[i]);
            } else {
                String now = stack.peek();

                if(array[i].equals(now)){
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }

            }

        }

        int answer =0;
        if(stack.isEmpty()){
            answer = 1;
        } else {
            answer = 0;

        }
        return answer;
    }
}