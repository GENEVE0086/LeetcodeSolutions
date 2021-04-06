// 1509-三次操作后最大值与最小值的最小差
//给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个元素并将它改成任意值。 
//
// 请你返回三次操作后， nums 中最大值与最小值的差的最小值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [5,3,2,4]
//输出：0
//解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
//最大值与最小值的差为 2-2 = 0 。 
//
// 示例 2： 
//
// 输入：nums = [1,5,0,10,14]
//输出：1
//解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
//最大值与最小值的差为 1-0 = 1 。
// 
//
// 示例 3： 
//
// 输入：nums = [6,6,0,1,1,4,6]
//输出：2
// 
//
// 示例 4： 
//
// 输入：nums = [1,5,6,14,15]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
// Related Topics 排序 数组 
// 👍 15 👎 0


package com.geneve.leetcode.editor.cn;

import org.omg.CORBA.ARG_IN;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves{
    public static void main(String[] args) {
        Solution solution = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if (len <= 4)
            return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int l1 = nums[0];
        int l2 = nums[1];
        int l3 = nums[2];
        int l4 = nums[3];

        int r1 = nums[len - 1];
        int r2 = nums[len - 2];
        int r3 = nums[len - 3];
        int r4 = nums[len - 4];

        // l1 l2 l3 |
        ans = Integer.min(ans,r1 - l4);
        // l1 l2 | r1
        ans = Integer.min(ans,r2 - l3);
        // l1 | r1 r2
        ans = Integer.min(ans,r3 - l2);
        // | r1 r2 r3
        ans = Integer.min(ans,r4 - l1);

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}