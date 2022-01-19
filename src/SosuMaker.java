import java.lang.reflect.Array;
import java.util.Arrays;

public class SosuMaker {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int x,y,z;

        for(int i = 0; i<commands.length;i++){
            x = commands[i][0];
            y = commands[i][1];
            z = commands[i][2];
            int[] arr = new int[y-x+1];
            for(int j =x-1;j<y;j++){
                arr[j-(x-1)]= array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[z-1];
        }
        return answer;
    }
}
