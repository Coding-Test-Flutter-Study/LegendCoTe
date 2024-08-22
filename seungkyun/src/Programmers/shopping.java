import java.util.*;

class Solution {

    static int ans = 0;

    public int solution(String[] want, int[] number, String[] discount) {


        int left = 0;
        int right = 9;

        while (right < discount.length) {

            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < want.length; i++) {
                String goods = want[i];


                hashMap.put(goods, number[i]);

            }


            check(left, right, hashMap, discount);

            left++;
            right++;
        }

        return ans;
    }

    static void check(int left, int right, HashMap<String, Integer> hashMap, String[] discount) {
        for (int i = left; i <= right; i++) {

            String dis = discount[i];

            if (hashMap.containsKey(dis)) {
                if (hashMap.get(dis) != 0) {
                    hashMap.put(dis, hashMap.get(dis) - 1);
                }
            }
        }


        for (int a : hashMap.values()) {
            if (a != 0) {
                return;
            }
        }

        ans++;
    }


}