public class 단체사진찍기 {

    static String[] st;
    static boolean[] visited;
    int count =0;
    static char[] c = {'1','2','3','4','5','6','7','8'};

    public static boolean isCom(String st){


        if(){


        }


    }



    public int solution(int n, String[] data) {

        int siz=1;

        for(int i=1;i<=8;i++){
            siz*=i;
        }
        st = new String[8];
        visited = new boolean[8];




        StringBuffer[] sb = new StringBuffer[data.length];
        for(int i=0;i<sb.length;i++){

            sb[i] = new StringBuffer(data[i]);

            for(int j=0;j<sb[i].length();j++){
                sb[i].charAt(j)
            }
        }



        int answer = 0;
        return answer;
    }

}
