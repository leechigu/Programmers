import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class KaKao112Result {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer =  new int[id_list.length];
        ArrayList<String> starr;
        HashSet<String> hash = new HashSet<>();//hashset을 통한 중복 제거 ***
        for(int i = 0; i<report.length;i++){
            hash.add(report[i]);
        }
        starr = new ArrayList<>(hash);
        int[] a= new int[starr.size()];
        int[] b= new int[starr.size()];
        for(int i = 0;i< starr.size();i++){
            String[] temp = starr.get(i).split("\\s");
            for(int j =0;j<id_list.length;j++){
                if(temp[0].equals(id_list[j])){
                    a[i] = j;
                }
                if(temp[1].equals(id_list[j])){
                    b[i] = j;
                }
            }
        }
        int[] count = new int[id_list.length];
        for(int i = 0;i<b.length;i++){
            count[b[i]]++;
        }
        for(int i=0;i<count.length;i++) {
            if(count[i]>=k){ //카운트 된 횟수 확인
                for(int j = 0;j<b.length;j++){
                    if(id_list[i].equals(id_list[b[j]])){
                        answer[a[j]]++;
                    }
                }
            }

        }
        return answer;
    }
}
