import java.util.*;

class Solution {

    static ArrayList<Integer> answer = new ArrayList<>();

    static HashMap<String, Integer> hashMap = new HashMap<>();

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        for(int i=0; i<name.length;i++){
            hashMap.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length;i++){
            int point =0;

            for(int j=0; j<photo[i].length;j++){
                point+=hashMap.getOrDefault(photo[i][j],0);
            }
            answer.add(point);
        }

        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size();i++){
            ans[i] = answer.get(i);
        }

        return ans;
    }
}