package example.iscu;

public class Circle {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {2,4,6,8},
                {1,3,5,7}
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("(" + i+","+j+") -->" + arr[i][j]);
            }
        }
    }
}
