import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

       static int[] toArray(List<Integer> toArr) {
           int[] arr = new int[toArr.size()] ;
           int i = 0;
           for (int integer : toArr) {
               arr[i] = integer;
               i++;
           }
           return arr;
       }
       static int[] partition(int[] ar) {
           if (ar == null || ar.length <= 1) {
               return ar;
           }
           int p = ar[0];

           List<Integer> left = new ArrayList();
           List<Integer> right = new ArrayList();
           for (int i = 1; i < ar.length; i++) {
               if (ar[i] < p) {
                   left.add(ar[i]);
               } else {
                   right.add(ar[i]);
               }
           }
           //recurse on each half

           int[] leftArr = partition(toArray(left));
           int[] rightArr = partition(toArray(right));

           //merge lists
           int i = 0;
           for (int integer : leftArr) {
               ar[i] = integer;
               i++;
           }
           ar[i] = p;
           i++;
           for (int integer : rightArr) {
               ar[i] = integer;
               i++;
           }
           printArray(ar);
           return ar;
       }

       static void quickSort(int[] ar) {
           partition(ar);
       }

       static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }

      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt();
           }
           quickSort(ar);
       }
   }