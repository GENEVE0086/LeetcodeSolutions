// 面试题 17.21-直方图的水量
//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 225 👎 0

package com.geneve.leetcode.editor.cn;

public class VolumeOfHistogramLcci {

  public static void main(String[] args) {
    Solution solution = new VolumeOfHistogramLcci().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int trap(int[] height) {
      int len = height.length;
      if (len == 0 || len == 1 || len == 2) {
        return 0;
      }
      int[] left = new int[len];
      int[] right = new int[len];

      left[0] = height[0];
      right[len - 1] = height[len - 1];

      for (int i = 1; i < len; i++) {
        int j = len - 1 - i;
        left[i] = Math.max(height[i], left[i - 1]);
        right[j] = Math.max(height[j], right[j + 1]);
      }

      int ans = 0;

      for (int i = 0; i < len; i++) {
        ans += Math.min(left[i], right[i]) - height[i];
      }

      return ans;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}