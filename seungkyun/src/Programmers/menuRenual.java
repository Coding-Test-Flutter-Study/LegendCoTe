import java.util.*;

class Solution {

    static HashMap<String,Integer> hashMap;
    static int max=0;
    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> answer = new ArrayList<>();



        for(int i=0; i<course.length;i++){
            int courseNum = course[i];
            hashMap = new HashMap<>();
            for(int j=0; j<orders.length;j++){
                String menus = orders[j];
                String menu ="";
                String[] aa = menus.split("");
                Arrays.sort(aa);
                for(int k=0;k<aa.length;k++){
                    menu+=aa[k];
                }


                if(courseNum<=menu.length()){
                    cal(menu,"",courseNum,0,0);

                }


            }


            if(max>1){
                for(String key : hashMap.keySet()){

                    if(hashMap.get(key)==max){
                        answer.add(key);
                    }
                }
            }

            max =0;
        }
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for(int i=0; i<answer.size();i++){
            ans[i]=answer.get(i);
        }
        return ans;
    }

    static void cal(String menu, String newCourseMenu, int courseNum,int nowNum,int I){

        if(courseNum==nowNum){
            if(!hashMap.containsKey(newCourseMenu)){
                hashMap.put(newCourseMenu,1);
            } else {
                hashMap.put(newCourseMenu,hashMap.get(newCourseMenu)+1);
                max = Math.max(max,hashMap.get(newCourseMenu));
            }

            return;
        }


        for(int i=I; i<menu.length();i++){

            cal(menu,newCourseMenu+(menu.charAt(i)),courseNum,nowNum+1,i+1);


        }


    }
}