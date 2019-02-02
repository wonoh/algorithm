package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SA2005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            System.out.println("#"+a);
            int n = Integer.parseInt(br.readLine());
            List<Integer> arrayList[] = new List[n];
            for (int i = 0; i < n; i++) {
                arrayList[i] = new LinkedList<>();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        arrayList[i].add(1);
                    } else {
                        arrayList[i].add(arrayList[i - 1].get(j - 1) + arrayList[i - 1].get(j));
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            result.append("#" + a + "\n");
            for (int i = 0; i < n; i++) {
                for (int val : arrayList[i]) {
                    result.append(val + " ");
                }
                result.append("\n");
            }
            //System.out.println(result.toString());
        }
    }


}
