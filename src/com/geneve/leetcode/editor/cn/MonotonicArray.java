// 896-单调数列
//如果数组是单调递增或单调递减的，那么它是单调的。 
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。 
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[6,5,4,4]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[1,3,2]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[1,2,4,5]
//输出：true
// 
//
// 示例 5： 
//
// 输入：[1,1,1]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -100000 <= A[i] <= 100000 
// 
// Related Topics 数组 
// 👍 129 👎 0

package com.geneve.leetcode.editor.cn;

public class MonotonicArray {

  public static void main(String[] args) {
    Solution solution = new MonotonicArray().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isMonotonic(int[] A) {
      int len = A.length;
      if (len == 1) {
        return true;
      }
      int state = 0; // 0 - 未定 1 - 上升 2 - 下降
      int last;
      int cur;
      for (int i = 1; i < len; i++) {
        last = A[i - 1];
        cur = A[i];
        if (last == cur) {
          continue;
        }
        switch (state) {
          case 0:
            if (cur > last) {
              state = 1;
            } else {
              state = 2;
            }
            break;
          case 1:
            if (cur < last) {
              return false;
            }
            break;
          case 2:
            if (cur > last) {
              return false;
            }
            break;
          default:
            break;
        }
      }
      return true;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}