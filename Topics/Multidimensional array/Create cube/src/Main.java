import java.util.Arrays;

class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here
        int[][][] arr = new int[3][3][3];
        for (int i=0; i< arr.length; i++) {
            int x = 0;
           for (int j=0; j<arr[i].length; j++) {
               for (int g=0; g<arr[i][j].length; g++) {
                   arr[i][j][g] = x;
                   x++;
               }
           }
        }
        return arr;

    }
//    public static void main(String[] args) {
//        int[][][] ar = createCube();
//        System.out.println(Arrays.deepToString(ar));
//    }
}