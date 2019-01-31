package Kakao2019test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 a","Enter uid4567 b","Change uid1234 c","Leave uid4567","Enter uid4567 a"};
        System.out.println(solution(record));
    }

        public static String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < record.length; i++) {
                String[] splitArray = record[i].split(" ");
                System.out.println(Arrays.toString(splitArray));
                switch (splitArray[0]) {
                    case "Enter":
                        map.put(splitArray[1], splitArray[2]);
                        count++;
                        break;
                    case "Leave":
                        count++;
                        break;
                    case "Change":
                        map.remove(splitArray[1]);
                        map.put(splitArray[1], splitArray[2]);
                        break;
                }
            }
            System.out.println(map.toString());
            Vector<String> answer = new Vector<>();
            for(int i=0;i<record.length;i++){
                String[] splitArray = record[i].split(" ");
                if(splitArray[0].equalsIgnoreCase("Change")){
                    continue;
                }
                if(splitArray[0].equalsIgnoreCase("Enter")){
                    answer.add(map.get(splitArray[1])+"님이 들어왔습니다.");
                }else if(splitArray[0].equalsIgnoreCase("Leave")){
                    answer.add(map.get(splitArray[1])+"님이 나갔습니다.");
                }
            }
            String[] result = new String[answer.size()];
            int index =0;
            for(String s:answer){
                result[index] = s;
                index++;
            }
            return result;
    }
}
