// 15-三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2994 👎 0

package com.geneve.leetcode.editor.cn;

import java.util.List;
import java.util.ArrayList;

public class ThreeSum {

  public static void main(String[] args) {
    Solution solution = new ThreeSum().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
      if (nums.length == 0)
        return new ArrayList<>();
      // 排序去重
      java.util.Arrays.sort(nums);
      int len = 1;
      int[][] newNums = new int[nums.length][2];
      newNums[0][0] = nums[0];
      newNums[0][1] = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
          newNums[len][0] = nums[i];
          newNums[len][1] = 1;
          len++;
        }
        else {
          newNums[len - 1][1]++;
        }
      }

      List<List<Integer>> ans = new ArrayList<>();
      for (int i = 0; i < len; i++) {
        int cur = newNums[i][0];
        int l = i;
        int r = len - 1;
        while (l <= r) {
          if (cur + newNums[l][0] + newNums[r][0] == 0) {
            if (l == r && l == i && newNums[i][1] <3){
              break;
            }
            if (l == r && newNums[l][1] < 2){
              break;
            }
            if (i == l && newNums[i][1] < 2){
              l++;
              continue;
            }
            List<Integer> item = new ArrayList<>();
            item.add(cur);
            item.add(newNums[l][0]);
            item.add(newNums[r][0]);
            ans.add(item);
            l++;
          }else if (cur + newNums[l][0] + newNums[r][0] > 0) {
            r--;
          }else if (cur + newNums[l][0] + newNums[r][0] < 0) {
            l++;
          }
        }
      }

      return ans;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}