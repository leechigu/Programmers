import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class 메뉴리뉴얼 {

    public static String[] ords;
    public static HashMap<String,Integer> hashMap;

    public static void dfs(char[] order, boolean[] isVisited, int select, int cnt, int curPos){

        if(cnt==select){
            String temp = "";
            for(int i=0;i<isVisited.length;i++){
                if(isVisited[i])
                    temp+=order[i];
            }
            check(temp);
            return;
        }

        for(int i=curPos;i<order.length;i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            dfs(order,isVisited,select,cnt+1,i);
            isVisited[i] = false;

        }
    }


    public static void check(String course){
        int cnt = 0;
        for(int i=0;i<ords.length;i++){
            if(isContaion(ords[i],course)){
                cnt++;
            }
        }
        if(cnt>=2 && !hashMap.containsKey(course)){
            hashMap.put(course,cnt);
        }
    }

    public static boolean isContaion(String order,String nCourse){
        char[] orderChar = order.toCharArray();
        char[] nCourseChar = nCourse.toCharArray();


        int cnt =0;
        for(int i=0;i<nCourseChar.length;i++){
            for(int j=0;j<orderChar.length;j++){
                if(orderChar[j]==nCourseChar[i]){
                    cnt++;
                    break;
                }
            }
        }
        if(cnt == nCourseChar.length)
            return true;
        else
            return false;
    }

    public static String[] solution(String[] orders, int[] course) {

        for(int i=0;i<orders.length;i++){
            String temp = orders[i];
            char[] tempChar = temp.toCharArray();
            Arrays.sort(tempChar);
            temp = "";
            for(int j=0;j<tempChar.length;j++){
                temp+=tempChar[i];
            }
            orders[i] = temp;
        }


        hashMap = new HashMap<>();

        ords = orders;
        for(int i=0;i<orders.length;i++) {
            char[] orderChars = orders[i].toCharArray();
            for (int j = 0; j < course.length; j++) {
                int length = course[j];
                boolean[] isVisited = new boolean[orderChars.length];
                dfs(orderChars, isVisited, length, 0, 0);
            }
        }

        int[] arr = new int[course.length];

        for(int i=0;i<course.length;i++){
            int max = 0;
            for(String Key : hashMap.keySet()){
                if(Key.length()==course[i]){
                    if(hashMap.get(Key)>max){
                        max = hashMap.get(Key);
                    }
                }
            }
            arr[i] = max;
        }

        ArrayList<String> rtnList = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            for(String Key : hashMap.keySet()){
                if(Key.length()==course[i]){
                    if(hashMap.get(Key)==arr[i]){
                        rtnList.add(Key);
                    }
                }
            }
        }

        String[] rtn = rtnList.toArray(new String[rtnList.size()]);
        Arrays.sort(rtn);



        return rtn;
    }
}
