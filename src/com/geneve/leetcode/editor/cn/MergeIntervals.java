// 56-合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 891 👎 0

package com.geneve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

  public static void main(String[] args) {
    Solution solution = new MergeIntervals().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[][] merge(int[][] intervals) {
      int len = intervals.length;
      if (len == 0 || len == 1)
        return intervals;
      Item[] items = new Item[len];
      for (int i = 0; i < len; i++) {
        items[i] = new Item(intervals[i][0],intervals[i][1]);
//        System.out.println("item " +i+ "start:"+items[i].start+", end:"+items[i].end);
      }
      Arrays.sort(items);
      ArrayList<int[]> list = new ArrayList<>();
      int start = items[0].start;
      int end = items[0].end;
      for(Item item:items){
        int s = item.start;
        int e = item.end;
        if (s > end){
          list.add(new int[] {start, end});
          start = s;
          end = e;
        } else {
          end = Math.max(end,e);
        }
//        System.out.println("start:"+start+", end:"+end);
//        System.out.println("s:"+s+", e:"+e);
      }
      list.add(new int[] {start, end});
      return list.toArray(new int[list.size()][]);
    }

  }

  class Item implements Comparable<Item> {
    int start;
    int end;

    @Override
    public int compareTo(Item o) {
      return this.start - o.start;
    }

    public Item(int start, int end) {
      this.start = start;
      this.end = end;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)
}