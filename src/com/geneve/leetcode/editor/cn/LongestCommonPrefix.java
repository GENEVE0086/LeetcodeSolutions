// 14-最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1469 👎 0

package com.geneve.leetcode.editor.cn;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    Solution solution = new LongestCommonPrefix().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0)
        return "";
      String comPre = strs[0];
      for (int i = 1; i < strs.length; i++) {
        for (int j = 0; j < Math.min(comPre.length(), strs[i].length()); j++) {
          if (comPre.charAt(j) != strs[i].charAt(j)){
            comPre = comPre.substring(0,j);
            break;
          }
        }
        if (comPre.length() > strs[i].length())
          comPre = strs[i];
      }
      return comPre;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}