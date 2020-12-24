// 135-分发糖果
//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 380 👎 0


package com.geneve.leetcode.editor.cn;
public class Candy{
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int candy(int[] ratings) {
            int reslut = 0;
            int len = ratings.length;
            int[] rec1 = new int[len];
            rec1[0] = 1;
            rec1[len - 1] = 1;
            for (int i = 1, j = len - 2; i < len; i++, j--) {
                if (ratings[i] <= ratings[i - 1]){
                    rec1[i] = Integer.max(1, rec1[i]);
                } else {
                    rec1[i] = Integer.max(rec1[i - 1] + 1, rec1[i]);
                }

                if (ratings[j] <= ratings[j + 1]){
                    rec1[j] = Integer.max(1, rec1[j]);
                } else {
                    rec1[j] = Integer.max(rec1[j + 1] + 1, rec1[j]);
                }
            }
            for (int i = 0; i < len; i++) {
                reslut += rec1[i];
            }
            return reslut;
        }
//class Solution {
//        public int candy(int[] ratings) {
//            int reslut = 0;
//            int len = ratings.length;
//            int[] rec1 = new int[len];
//            int[] rec2 = new int[len];
//            rec1[0] = 1;
//            rec2[len - 1] = 1;
//            for (int i = 1, j = len - 2; i < len; i++, j--) {
//                if (ratings[i] <= ratings[i - 1]){
//                    rec1[i] = 1;
//                } else {
//                    rec1[i] = rec1[i - 1] + 1;
//                }
//
//                if (ratings[j] <= ratings[j + 1]){
//                    rec2[j] = 1;
//                } else {
//                    rec2[j] = rec2[j + 1] + 1;
//                }
//            }
//            for (int i = 0; i < len; i++) {
//                reslut += Math.max(rec1[i], rec2[i]);
//            }
//            return reslut;
//        }

//        public int candy(int[] ratings) {
//            int result = 0;
//            int len = ratings.length;
//            int rec[] = new int[len];
//            if (len == 1) {
//                return 1;
//            }
//            if (len == 2) {
//                if (ratings[0] == ratings[1])
//                    return 2;
//                else
//                    return 3;
//            }
//            for (int cnt = 0, l = 1; cnt < len; l++){
//                int r = 0;
//
//                if (ratings[0] <= ratings[1] &&
//                    ratings[0] != Integer.MAX_VALUE) {
//                    result += l;
//                    cnt++;
//                    rec[r++] = 0;
////                System.out.println("0:" + l);
//                }
//
//                if (ratings[len - 1] != Integer.MAX_VALUE &&
//                    ratings[len - 1] <= ratings[len - 2]){
//                    result += l;
//                    cnt++;
//                    rec[r++] = len - 1;
////                System.out.println(len-1 + ":" + l);
//                }
//
//                for (int i = 1; i < len - 1; i++) {
//                    if (ratings[i] <= ratings[i -1] && ratings[i] <= ratings[i + 1]){
//                        if (ratings[i] != Integer.MAX_VALUE) {
//                            result += l;
//                            cnt++;
//                            rec[r++] = i;
////                        System.out.println(i + ":" + l);
//                        }
//                    }
//                }
//                for (int i = 0; i < r; i++) {
//                    ratings[rec[i]] = Integer.MAX_VALUE;
//                }
//            }
//            return result;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}