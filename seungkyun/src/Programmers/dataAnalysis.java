import java.util.*;

class Solution {

    static HashMap<Integer, int[]> hashMap = new HashMap<>();

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        ArrayList<int[]> arrayList = new ArrayList<>();
        ArrayList<Integer> sortKeyList = new ArrayList<>();

        int e = EXT(ext);
        int e2 = EXT(sort_by);

        for(int i=0; i<data.length;i++){
            if(data[i][e]<val_ext){
                arrayList.add(data[i]);
                sortKeyList.add(data[i][e2]);
            }
        }

        Collections.sort(sortKeyList);

        for(int i=0; i<arrayList.size();i++){
            hashMap.put(arrayList.get(i)[e2],arrayList.get(i));
        }

        int[][] ans = new int[arrayList.size()][4];

        for(int i=0; i<sortKeyList.size();i++){
            int[] d = hashMap.get(sortKeyList.get(i));
            ans[i][0]=d[0];
            ans[i][1]=d[1];
            ans[i][2]=d[2];
            ans[i][3]=d[3];
        }

        return ans;
    }

    static int EXT(String ext){
        if(ext.equals("code")){
            return 0;
        } else if(ext.equals("date")){
            return 1;
        }else if(ext.equals("maximum")){
            return 2;
        } else {
            return 3;
        }

    }

}