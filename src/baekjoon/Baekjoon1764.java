    package baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Baekjoon1764 {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static List<String> list = new ArrayList<>();
        static Vector<String> answerList = new Vector<>();

        public static void main(String[] args) throws IOException {
            readLine();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                String name = br.readLine();
                list.add(name);
            }
            Collections.sort(list);
            System.out.println(list.toString());
            String[] array = new String[list.size()];
            for(int i=0;i< list.size();i++){
                array[i] = list.get(i);
            }
            for(int i=0;i<m;i++){
                String name = br.readLine();
                int index = binarySearch(name);
                System.out.println(index);
                if(index >= 0){
                    answerList.add(list.get(index));
                }
            }
            System.out.println(answerList.size());
            Collections.sort(answerList);
            for(String s:answerList){
                System.out.println(s);
            }

        }

        public static int binarySearch(String name) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                Comparable midVal = list.get(mid);
                int cmp = midVal.compareTo(name);
                if(cmp < 0){
                    left = mid + 1;
                }else if(cmp > 0 ){
                    right = mid - 1;
                }else{
                    return mid;
                }
            }
            return -1;
        }

        public static void readLine() throws IOException {
            st = new StringTokenizer(br.readLine(), " ");
        }

    }
