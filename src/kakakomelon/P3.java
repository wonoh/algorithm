package kakakomelon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3 {
    private static final int COLUMN_MAX_LENGTH = 702;
    private static final String[] alphabets = { "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    public static void main(String[] args) {
        //System.out.println(704%702);
        System.out.println(solution(702));
    }

    public static String solution(long n) {
        // Write your code here
        String cell = n % COLUMN_MAX_LENGTH == 0 ? String.valueOf(n / COLUMN_MAX_LENGTH) : String.valueOf(n / COLUMN_MAX_LENGTH + 1);
        List<String> columns = new ArrayList<>(Arrays.asList(alphabets));
        int point = 0;
        int alphabetsLength = alphabets.length;
        while(columns.size() < COLUMN_MAX_LENGTH){
            if(columns.size() % alphabetsLength == 0){
                for (String alphabet : alphabets) {
                    columns.add(alphabets[point] + alphabet);
                }
                point++;
            }
        }
        int columnIndex = Math.toIntExact(n % COLUMN_MAX_LENGTH == 0 ? COLUMN_MAX_LENGTH - 1 : n % COLUMN_MAX_LENGTH - 1);
        return cell + columns.get(columnIndex);
    }
}
