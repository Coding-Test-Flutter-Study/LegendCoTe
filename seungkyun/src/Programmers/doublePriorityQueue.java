import java.util.*;

class Solution {

    static PriorityQueue<Integer> PQ = new PriorityQueue<>();
    static PriorityQueue<Integer> reversePQ = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = {};

        for(int i=0; i< operations.length;i++){
            go(operations[i]);
        }

        if(PQ.isEmpty()){
            return new int[] {0,0};
        } else{
            int[] ans = new int[2];
            ans[1]=PQ.peek();
            move(PQ,reversePQ);
            ans[0]=reversePQ.peek();
            return ans;
        }
    }



    static void go(String order){
        String[] array = order.split(" ");

        String od = array[0];
        int i = Integer.parseInt(array[1]);

        if(od.equals("I")){
            PQ.offer(i);
        } else if(i==-1){
            if(!PQ.isEmpty()){
                PQ.poll();
            }

        } else {
            if(!PQ.isEmpty()){
                move(PQ,reversePQ);
                reversePQ.poll();
                move(reversePQ,PQ);
            }

        }

    }

    static void move(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2){
        while(!p1.isEmpty()){
            p2.offer(p1.poll());
        }
    }
}