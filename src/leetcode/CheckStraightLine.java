package leetcode;

public class CheckStraightLine {

    public static void main(String[] args) {

        int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int x = coordinates[0][0];
        int y = coordinates[0][1];
        for(int i =1;i<coordinates.length;i++){
            if((coordinates[i][1]-y) != (coordinates[i][0]-x)){
                return false;
            }
        }
        return true;

    }

}
