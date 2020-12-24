// 6-Z 字形变换
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 944 👎 0


package com.geneve.leetcode.editor.cn;
public class ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder builder = new StringBuilder();
        int index = numRows * 2 - 2;
        int t = s.length() / index;
        int p = s.length() % index;
//        System.out.print(index + " " + t + " " + p);
        for (int i = 0; i < t; i++) {
            builder.append(s.charAt(i * index));
        }
        if (p > 0){
            builder.append(s.charAt(t * index));
        }
        for (int j = 1; j < numRows - 1; j++) {
            for (int i = 0; i < t; i++) {
                builder.append(s.charAt(j + i * index));
                builder.append(s.charAt((i + 1) * index - j));
            }
            if (p > index - j) {
                builder.append(s.charAt(t * index + j));
                builder.append(s.charAt((t + 1) * index - j));
                continue;
            }
            if (p > j) {
                builder.append(s.charAt(t * index + j));
            }
        }
        for (int i = 0; i < t; i++) {
            builder.append(s.charAt(i * index + numRows - 1));
        }
        if (p >= numRows)
            builder.append(s.charAt(t * index + numRows - 1));
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}