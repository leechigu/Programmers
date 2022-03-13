import java.util.*;

public class 튜플 {
    public static String[] strings;
    public static void stringSlice(String s){
        ArrayList<String> stringArrayList =new ArrayList<>();
        String temp = "";
        for(int i=1;i<s.length()-1;i++) {
            temp += s.charAt(i);
            if (s.charAt(i) == '}') {
                stringArrayList.add(temp);
                temp = "";
                i++;
            }
        }
        strings = new String[stringArrayList.size()];
        for(int i=0;i<strings.length;i++){
            temp = stringArrayList.get(i);
            temp =temp.substring(1,temp.length()-1);
            strings[i] = temp;
        }
    }
    public static int[] getIntegersFromString(String st){
        int size = 0;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i) ==',')
                size++;
        }
        int[] re = new int[size+1];
        String temp ="";
        int cnt=0;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)==','){
                temp="";
                cnt++;
                continue;
            }
            temp += st.charAt(i);

        }
        re[re.length-1] = Integer.parseInt(temp);
        return re;
    }
    public int[] solution(String s) {
        stringSlice(s);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            int[] temp = getIntegersFromString(strings[i]);
            for(int j=0;j<temp.length;j++){
                if(!arrayList.contains(temp[j])){
                    arrayList.add(temp[j]);
                    break;
                }
            }
        }
        int[] answer = new int[arrayList.size()];
        int cnt =0;
        Iterator<Integer> it =  arrayList.iterator();
        while(it.hasNext()){
            answer[cnt] = it.next();
            cnt++;
        }
        return answer;
    }

}
