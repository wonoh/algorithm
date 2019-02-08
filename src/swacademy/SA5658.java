package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wonoh
 * 보물상자 비밀번호
 * https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
 */
public class SA5658 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            List<String> list = new ArrayList<>();
            readLine();
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String[] splitArray = br.readLine().split("");
            int rotate = 0;
            int max_rotate = n/4;
            while(rotate < max_rotate){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<splitArray.length;i+=max_rotate){
                    sb.append(splitArray[i]);
                    for(int j=i+1;j<i+max_rotate;j++){
                        sb.append(splitArray[j]);
                    }
                    if(list.contains(sb.toString())){
                        sb.setLength(0);
                        continue;
                    }
                    list.add(sb.toString());
                    sb.setLength(0);
                }
                String last = splitArray[splitArray.length-1];
                for(int i=splitArray.length-2;i>=0;i--){
                    splitArray[i+1] = splitArray[i];
                }
                splitArray[0] = last;
                rotate++;
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    long o1_val = getValue(o1);
                    long o2_val = getValue(o2);
                    return (int) (o2_val - o1_val);
                }
            });
            System.out.println("#"+a+" "+getValue(list.get(k-1)));
        }
    }
    public static int getValue(String hex){
        long val = Long.parseLong(hex,16);
        return (int)val;
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
