package Demo.GreedyAl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。注意:可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1: 输入: [ [1,2], [2,3], [3,4], [1,3] ] 输出: 1 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2: 输入: [ [1,2], [1,2], [1,2] ] 输出: 2 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3: 输入: [ [1,2], [2,3] ] 输出: 0 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */

public class ga1 {
    private static class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    public static Integer removeDuplicateInterval(Interval[] intervals){

        //将区间按起始点有小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a.start));

        //首次递归从-1，0开始
        return removeSubDuplicate(-1,0,intervals);
    }
    private static HashMap<String,Integer> hashMap=new HashMap();
    private static Integer removeSubDuplicate(int pre,int cur,Interval[] intervals){
        String key=pre+","+cur;
        if (hashMap.get(key)!=null){
            return hashMap.get(key);
        }

        if (cur==intervals.length){
            return 0;
        }

        int notRemove =Integer.MAX_VALUE;
        if (pre==-1||intervals[pre].end<=intervals[cur].start){
            //首次递归或者不重复时
            notRemove=removeSubDuplicate(cur,cur+1,intervals);
//            System.out.println("notRemove"+notRemove);
        }
        /**
         *如果pre区间的终点大于cur区间的起点,代表两区间重叠,则cur指向后一个区间,即cur=cur+1;
         * 移除cur,所以需要加1
         */
        int remove =removeSubDuplicate(pre,cur+1,intervals)+1;
//        System.out.println("remove"+remove);
//        System.out.println("______________");
        int result =Math.min(notRemove,remove);
        hashMap.put(key,result);
        return result;
    }

    private static boolean isOverLapping(Interval i,Interval j){
        return j.end>i.start;
    }

    private static Integer removeSubDuplicateWithDP(Interval[] intervals){
        Arrays.sort(intervals,Comparator.comparingInt(a->a.start));

        int[] dp=new int[intervals.length];

        Arrays.fill(dp,0);
        dp[0]=1;
        int result=1;
        for (int i=1;i<intervals.length;i++){
            int max=0;
            for (int j=0;j<i;j++){
                if (!isOverLapping(intervals[i],intervals[j])){
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
        }
        return intervals.length-dp[intervals.length-1];
    }

    private static Integer removeSubDuplicateWithGreedy(Interval[] intervals){
        Arrays.sort(intervals,Comparator.comparingInt(a->a.start));
        int curr=0; //设置第一个当前区间
        int count=1; //最大不重叠区间数，最小为1

        for (int i=1;i<intervals.length;i++){
            //不重叠
            if (intervals[curr].end<intervals[i].start){
                curr=i;
                count++;
            }
        }
        //总区间数减去不重叠区间数即最小被移除重叠区间
        return intervals.length-count;
    }

    public static void main(String[] args) {
        Interval[] intervals={
                new Interval(1,2),
                new Interval(3,5),
                new Interval(4,7),
                new Interval(8,10),
                new Interval(9,11)
        };
      //  int result=removeDuplicateInterval(intervals);
        int result1=removeSubDuplicateWithDP(intervals);
        System.out.println("result="+result1);
    }
}
