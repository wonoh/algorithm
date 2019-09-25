package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {


        System.out.println(romanToInt("III"));
    }

    private static int romanToInt(String s){

        int answer = 0;

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int length = s.length();

        for (int i = 0; i < length; i++) {

            if(i+1 == length){
                answer += map.get(s.charAt(i));
                break;
            }

            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                answer += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                i++;
            }else{
                answer += map.get(s.charAt(i));
            }
        }
        return answer;
    }

}
