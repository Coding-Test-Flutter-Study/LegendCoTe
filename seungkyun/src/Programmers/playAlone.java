import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];

        for(int i=0; i<cards.length;i++){

            if(!visited[i]){
                int ans =1;
                visited[i]=true;

                int nowLocation = cards[i]-1;

                while(true){
                    if(!visited[nowLocation]){
                        visited[nowLocation]=true;
                        nowLocation = cards[nowLocation]-1;
                        ans++;
                    } else {
                        break;
                    }

                }

                arrayList.add(ans);
            }

        }

        Collections.sort(arrayList,Collections.reverseOrder());

        if(arrayList.size()==1){
            return 0;
        }

        return arrayList.get(0)* arrayList.get(1);
    }
}