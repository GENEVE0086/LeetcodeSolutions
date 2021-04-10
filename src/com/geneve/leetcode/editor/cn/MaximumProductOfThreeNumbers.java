// 628-三个数的最大乘积
//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 
// 👍 290 👎 0


package com.geneve.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers{
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return 0;
        Arrays.sort(nums);
        int l1 =  nums[0];
        int l2 =  nums[1];

        int r1 =  nums[len - 1];
        int r2 =  nums[len - 2];
        int r3 =  nums[len - 3];

        return Math.max(l1 * l2 * r1, r1 * r2 * r3);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}