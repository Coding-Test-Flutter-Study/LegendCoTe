
class Solution {

    static int count;
    static String target;
    static int ans;

    static String[] array = {"A","E","I","O","U"};

    public int solution(String word) {

        target = word;
        dfs("");

        return ans;
    }

    static void dfs(String str){



        if(str.length()<5){
            for(int i=0; i<5;i++){

                StringBuilder sb = new StringBuilder(str);

                String string = sb.append(array[i]).toString();
                count++;
                if(string.equals(target)){
                    ans = count;
                    return;
                }
                dfs(string);

            }
        }

    }
}