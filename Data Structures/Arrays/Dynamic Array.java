/*Create a list, seqList, of n empty sequences, where each sequence is indexed from 0 to n-1. The elements within each of the n sequences also use 0-indexing.
Create an integer, lastAnswer, and initialize it to 0.
There are 2 types of queries that can be performed on the list of sequences:
    1. Query: 1 x y
          a. Find the sequence, seq, at index ((x xor lastAnswer)%n) in seqList.
          b. Append integer y to sequence seq.
    2. Query: 2 x y
         a. Find the sequence, seq, at index ((x xor lastAnswer)%n) in seqList.
         b. Find the value of element y%size in seq (where size is the size of seq) and assign it to 
              lastAnswer.
         c. Print the new value of lastAnswer on a new line

Note: xor is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.  is the modulo operator.
Function Description:
Complete the dynamicArray function below.
dynamicArray has the following parameters:
- int n: the number of empty sequences to initialize in seqList.
- string queries[q]: an array of query strings
Returns
int[]: the results of each type 2 query in the order they are presented
Input Format:
The first line contains two space-separated integers, n (the number of sequences) and q (the number of queries), respectively.
each of the  subsequent lines contains a query in the format defined above, queries[i].
Constraints:
    1. 1<=n,q<=10^5
    2. 0<=x<=10^9
    3. 0<=y<=10^9
    4. It is guaranteed that query type  will never query an empty sequence or index.*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        List<Integer>[] sequences = new List[n];
        for (int n_i = 0; n_i < n; n_i++) {
            sequences[n_i] = new ArrayList<>();
        }
        int lastans = 0;
        for (int i = 0; i < q; i++) {
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            List<Integer> sequence = sequences[(x^lastans)%n];
            switch (t) {
                case 1:
                    sequence.add(y);
                    break;
                case 2:
                    lastans = sequence.get(y%sequence.size());
                    System.out.println(lastans);
                    break;
            }
        }
    }
}
