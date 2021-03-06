//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2388 👎 0

package com.geneve.leetcode.editor.cn;

public class ReverseInteger {

  public static void main(String[] args) {
    Solution solution = new ReverseInteger().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int reverse(int x) {
      StringBuffer X = new StringBuffer(String.valueOf(x));
      char sign = X.charAt(0);
      StringBuffer resultInString = new StringBuffer();
      if (sign == '-') {
        resultInString.append('-');
        resultInString.append(new StringBuffer(X.substring(1)).reverse());
      }
      else
        resultInString.append(X.reverse());
      int reslut;
      String res = resultInString.toString();
      try {
        reslut = Integer.parseInt(res);
      } catch (Exception e){
        return 0;
      }
      return reslut;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)


//leetcode submit region begin(Prohibit modification and deletion)
  class Solution1 {

    public int reverse(int x) {
      int result = 0;
      while (x != 0) {
        int tmp = x % 10;
        if (result > Integer.MAX_VALUE / 10 ||
            result == Integer.MAX_VALUE / 10 && tmp > 7)
          return 0;

        if (result < Integer.MIN_VALUE / 10 ||
            result == Integer.MIN_VALUE / 10 && tmp < -8)
          return 0;

        result = result * 10 + tmp;
        x /= 10;
      }
      return result;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}