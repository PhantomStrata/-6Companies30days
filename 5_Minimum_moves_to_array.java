import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        /* by using arry.sort and sorting it first
           we get the median value and then we can get the least moves
           The median ensures that the total distance from the selected value to all other values is minimized
         */

         Arrays.sort(nums);

         int mid = (nums.length/2);
         int median = nums[mid];
         int moves = 0;

         for (int number : nums)
         {
            moves += Math.abs(number - median); // the absolute difference 
         }

         return moves;
    }
}