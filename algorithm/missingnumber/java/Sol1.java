package missingnumber1;

import java.util.Arrays;

/**
 * Created by davidtan on 10/29/16.
 */
public class Sol1 {
    public int missingNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i< nums.length; i++){
            r ^=  i ^ nums[i];
        }
        return r ^ nums.length;
    }
    public int bySum(int[] nums){
        int n = nums.length +2; //2 depends on missing
        int sum = n*(n+1)/2;
        int sumT = Arrays.stream(nums).sum();
        return Math.abs(sum -sumT);

    }
    public static void main(String[] args){
        int[] A = {1,2,4,5,7};
        Sol1 solution = new Sol1();
        System.out.println(solution.missingNumber(A));//4
        System.out.println(solution.bySum(A));//9 , 3,6
        A = new int[]{1,2,4,5,6};
        System.out.println(solution.bySum(A));//10 , 3,7


    }
}

