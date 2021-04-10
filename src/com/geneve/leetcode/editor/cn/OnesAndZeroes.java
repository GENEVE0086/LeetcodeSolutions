// 474-一和零
//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 374 👎 0

package com.geneve.leetcode.editor.cn;

public class OnesAndZeroes {

  public static void main(String[] args) {
    Solution solution = new OnesAndZeroes().new Solution();
  }

  // 背包问题，有点生疏了，需要专门的练习了

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
      int len = strs.length;
      int[][] dp = new int[m + 1][n + 1];
      int[] one = new int[len];
      int[] zero = new int[len];
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < strs[i].length(); j++) {
          if (strs[i].charAt(j) == '0') {
            zero[i]++;
          } else {
            one[i]++;
          }
        }
      }
      for (int i = 0; i < len; i++) {
        for (int j = m; j >= zero[i]; j--) {
          for (int k = n; k >= one[i] ; k--) {
            dp[j][k] = Math.max(dp[j][k],dp[j - zero[i]][k - one[i]] + 1);
          }
        }
      }
      return dp[m][n];
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}