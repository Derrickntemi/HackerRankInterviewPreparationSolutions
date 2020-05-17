package solutions;

public class ArrayManipulationUsingPrefixSumAlgorithm {
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n+1];
        for(int i=0;i<queries.length;i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            array[a-1]+=k;
            array[b]-=k;
        }
        return findArrayMax(array);
    }

    static long findArrayMax(long[] array){
        long max = Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            array[i]+=array[i-1];
            max = Math.max(array[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] queries = new int[3][3];
        queries[0][0]=1;
        queries[0][1]=2;
        queries[0][2]=100;
        queries[1][0]=2;
        queries[1][1]=5;
        queries[1][2]=100;
        queries[2][0]=3;
        queries[2][1]=4;
        queries[2][2]=100;
        System.out.print(arrayManipulation(5,queries));
    }
}
