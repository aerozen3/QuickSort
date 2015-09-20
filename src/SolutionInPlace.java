/**
 * Created by Zennard on 9/19/2015.
 */
public class SolutionInPlace {
    static void quickSort(int[] ar, int start, int end) {
        if (ar == null || ar.length <= 1 || (end - start) < 2) {
            return;
        }
        int p = ar[end-1];
        int swapIdx = start;
        for (int i = start; i < end-1; i++) {
            if (ar[i] < p) {
                //swap
                int tmp = ar[swapIdx];
                ar[swapIdx] = ar[i];
                ar[i] = tmp;
                swapIdx++;
            } else {
                //ar[i] > p
            }
        }
        //System.out.println("pre:" + swapIdx + " end:"+(end-1));
        //printArray(ar);
        int tmp = ar[swapIdx];
        ar[swapIdx] = ar[end-1];
        ar[end-1] = tmp;
        //System.out.println("final");
        printArray(ar);
        //recurse on each half

        //System.out.println("start:"+start+" end:"+end+" p:"+swapIdx);
        quickSort(ar, start, swapIdx);
        quickSort(ar, swapIdx+1, end);
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
        quickSort(ar, 0, n);
    }
}