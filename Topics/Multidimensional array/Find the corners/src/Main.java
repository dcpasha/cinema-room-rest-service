import java.util.Arrays;

class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
//        for (int i = 0; i < twoDimArray.length; i++) {
//            System.out.println(Arrays.toString(twoDimArray[i]));
//        }
//        System.out.println("My output");
        System.out.print(twoDimArray[0][0] + " ");
        System.out.println(twoDimArray[0][twoDimArray[0].length-1]);
        System.out.print(twoDimArray[twoDimArray.length-1][0] + " ");
        System.out.println(twoDimArray[twoDimArray.length-1][twoDimArray[twoDimArray.length-1].length-1]);

//        for (int i = 0; i < twoDimArray.length; i++) {
//            for (int j = 0; j < twoDimArray[i].length; j++) {
//
//                if (i == 0 && j == 0) {
//                    System.out.print(twoDimArray[i][j] + " ");
//                }
//
//                if (i == 0 && j == twoDimArray[i].length-1) {
//                    System.out.println(twoDimArray[i][j] + " ");
//                }
//
//                if (i == twoDimArray.length-1 && j == 0) {
//                    System.out.print(twoDimArray[i][j] + " ");
//                }
//
//                if (i == twoDimArray.length-1 && j == twoDimArray[i].length-1) {
//                    System.out.print(twoDimArray[i][j]);
//                }
//
//            } // inner for
//        }  // outer for

    }

//    public static void main(String[] args) {
//        int[][] arr;
////        arr = new int[3][5];
//      arr = new int[3][1];
//        int element = 1;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = element;
//                element++;
//            }
//        } // end for loop
//        printCorners(arr);
//    }  // end main


}