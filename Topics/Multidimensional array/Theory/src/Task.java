 // You can experiment here, it won’t be checked


 import java.util.Arrays;

 public class Task {
  public static void main(String[] args) {
    // put your code here
    int[][] arr;
    arr = new int[2][3];
//      arr = new int[3][1];

    int element = 1;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = element;
        element++;
      }
    } // end for loop

    for (int i = 0; i <arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }
}
