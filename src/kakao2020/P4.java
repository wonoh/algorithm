package kakao2020;

import java.util.Arrays;

public class P4 {

    public static void main(String[] args) {


        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o","fr???", "fr???", "fro???", "pro?"};
       solution(words, queries);
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            String query = queries[i];
            int count = 0;
            int endIndex = -1;
            int startIndex = -1;
            if(query.charAt(0) == '?'){
                for (int j = 1; j < queries.length ; j++) {
                    if(query.charAt(j) != '?'){
                        startIndex = j;
                        break;
                    }
                }
            }else{
                for (int j = 1; j < queries.length; j++) {
                    if(query.charAt(j) == '?'){
                        endIndex = j;
                        break;
                    }
                }
            }

            for (int j = 0; j < words.length; j++) {
                String word = words[j];

                if(word.length() != query.length()){
                    continue;
                }
                int sameCount = 0;
                if(startIndex == -1){
                    for (int k = 0; k < endIndex; k++) {
                        if(word.charAt(k) == query.charAt(k)){
                            sameCount++;
                        }
                    }
                    if(sameCount == endIndex){
                        count++;
                    }
                }else{
                    for (int k = startIndex; k < word.length() ; k++) {
                        if(word.charAt(k) == query.charAt(k)){
                            sameCount++;
                        }
                    }
                    if(sameCount == word.length() - startIndex){
                        count++;
                    }
                }
            }
            answer[i] = count;

        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

}
