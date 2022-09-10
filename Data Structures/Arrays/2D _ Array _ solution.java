/*
let's say we have a 2-dimensional array. just like as shown below.
a  b  c  0  0  0
0  d  0  0  0  0
e  f   g  0  0  0
0  0  0  0  0  0
0  0  0  0  0  0
0  0  0  0  0  0
so here the one hourglass of an array is that follows the pattern. just like this...
a b c
  d  
e f g
so if we have an array of size 6x6 then there is 16 hourglass present in the array. so here in this problem, 
we need to print the hourglass sum that has a maximum value. and the input array is fixed that is a 6x6 or 2-dimensional array
*/
import java.util.Scanner;
public class Intro2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int multiDimArr[][] = new int[6][6];
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 6;col++){
                multiDimArr[row][col] = sc.nextInt();
            }
        }
        System.out.println(Solve(multiDimArr));
    }
    static int Solve(int arr[][]){
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int row = 0; row < 4; row++){
            
            for(int col = 0; col < 4; col++ ){
                
                total = arr[row][col] + arr[row][col+1] + arr[row][col+2];
                total += arr[row+1][col+1];
                total += arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
                max = total>max?total:max;
            }
        }
        return max;
        }
}
