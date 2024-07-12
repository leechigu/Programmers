package 프로그래머스.LEVEL2;

import java.util.*;

public class 방금그곡 {
    public int calPlayingTime(String stTime,String edTime){

        String[] st = stTime.split(":");
        int stH = Integer.parseInt(st[0]);
        int stM = Integer.parseInt(st[1]);

        String[] ed = edTime.split(":");
        int edH = Integer.parseInt(ed[0]);
        int edM = Integer.parseInt(ed[1]);

        return (edH-stH)*60+(edM-stM);
    }

    public int calMelodyLength(String melody){
        int length = 0;

        for(int i=0;i<melody.length();i++){
            if(melody.charAt(i)=='#')
                continue;
            length++;
        }
        return length;
    }


    public String splitMelodyExceptRound(String melody,int length){

        String splitMelody = "";

        for(int i=0;i<melody.length();i++){
            //길이가 계산이 완료되면 종료
            if(length==0){
                break;
            }

            char temp = melody.charAt(i);
            splitMelody+=temp;

            if(i<melody.length()-1){
                //다음 문자가 #인 경우 #도 포함하기 위함
                char next = melody.charAt(i+1);
                if(next == '#'){
                    splitMelody+=next;
                    i++;
                }
            }
            length--;
        }
        return splitMelody;
    }

    public String calPlayingMelody(String melody,int playingTime){

        int melodyLen = calMelodyLength(melody);
        String playingMelody = "";

        if(melodyLen<playingTime){
            //멜로디가 짧을 경우
            int a = playingTime/melodyLen;
            int b = playingTime%melodyLen;

            for(int i=0;i<a;i++)
                playingMelody += melody;

            playingMelody += splitMelodyExceptRound(melody,b);


        }else if(melodyLen>playingTime){
            //멜로디가 더 길 경우
            playingMelody += splitMelodyExceptRound(melody,playingTime);
        }
        else if(melodyLen == playingTime){
            //같을 경우
            playingMelody += melody;
        }

        return playingMelody;

    }

    public boolean isContains(String a , String b){
        boolean bool = false;

        //먼저 문자열이 있는지 체크 : 없는 경우를 빠르게 제거하기 위함
        if(a.contains(b)){

            //잘못된 문자열 제거 ex)ABC가 포함된 문자열을 찾고 싶은데 ABC#이 포함된 문자열도 찾게됨 강제로 ABC#에 해당하는 문자열을 생성 후 제거하면 해당 케이스 피해 갈 수 있음.
            String wrong = b+"#";
            a = a.replace(wrong,"");
            if(a.contains(b)){
                bool = true;
            }

        }

        return bool;
    }


    public String solution(String m, String[] musicinfos) {


        List<String> titleList = new ArrayList<>();
        List<String> playingMelodyList = new ArrayList<>();

        for(int i=0;i<musicinfos.length;i++){

            String[] musicinfo = musicinfos[i].split(",");

            String stTime = musicinfo[0];
            String edTime = musicinfo[1];

            //곡 연주 시간 계산
            int playingTime = calPlayingTime(stTime,edTime);

            String title = musicinfo[2];
            String melody = musicinfo[3];

            //실제 연주된 멜로디 계산
            String playingMelody = calPlayingMelody(melody,playingTime);


            titleList.add(title);
            playingMelodyList.add(playingMelody);
        }

        int maxLen = -1;
        int indx = -1;

        for(int i=0;i<playingMelodyList.size();i++){
            String playingMelody = playingMelodyList.get(i);

            if(isContains(playingMelody,m)){
                if(calMelodyLength(playingMelody)>maxLen){
                    indx = i;
                    maxLen = calMelodyLength(playingMelody);
                }
            }
        }


        return indx!=-1?titleList.get(indx):"(None)";
    }
}
