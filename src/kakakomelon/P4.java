package kakakomelon;

import java.util.HashMap;
import java.util.Map;

public class P4 {

    private static char[] alphabets;
    private static Map<Character,Character> map = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long znmd = solution("AZGB");
        long end = System.currentTimeMillis();
        System.out.println(znmd);

        /*System.out.println("정답"+times);
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");


        System.out.println((int)'Z' + 13);
*/

    }

    public static long solution(String str) {

        alphabets = new char[26];

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            if(c <= 77){
                char half = (char) ((int) c + 13);
                map.put(c,half);
                map.put(half,c);
            }
            alphabets[i] = c;
        }
        System.out.println(map);

        char[] chars = str.toCharArray();

        long totalTime = 0;
        int currentPosition = 0;
        for (char target : chars) {
            Character half = map.get(alphabets[currentPosition]);
            System.out.println("현재 위치"+ alphabets[currentPosition] + "반 "+half + "타겟"+ target);

            long time = target >= half ? getBackwardTime(currentPosition, target) : getForwardTime(currentPosition, target);
            System.out.println("걸린시간"+time);
            //long time = Math.min(getForwardTime(currentPosition, target), getBackwardTime(currentPosition, target));
            totalTime += time;

            currentPosition = target - 'A';
        }

        return totalTime;
    }

    private static long getBackwardTime(int currentPosition, char target) {
        System.out.println("뒤로");
        long times = 0;
        while (alphabets[currentPosition] != target) {
            currentPosition--;
            times++;
            if (currentPosition < 0) {
                currentPosition = alphabets.length - 1;
            }
        }
        return times;
    }

    private static long getForwardTime(int currentPosition, char target) {
        System.out.println("앞으로");
        long times = 0;
        while (alphabets[currentPosition] != target) {
            times++;
            currentPosition++;
            if (currentPosition == alphabets.length) {
                currentPosition = 0;
            }
        }
        return times;
    }


}