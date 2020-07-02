package Demo.recursion;

import java.util.HashMap;
import java.util.Map;

public class recursionDemo {

    public int solve1(int m){
        if(m<=2){
            return m;
        }
        else{
            return solve1(m-1)+solve1(m-2);
        }
    }

    public int solve2(int m){
        int fb1=0;
        int fb2=1;
        int sum=0;
        if(m==1){
            return 1;
        }else if(m==2){
            return 2;
        }
            for(int i=0;i<=m;i++){
                sum=fb1+fb2;
                fb1=fb2;
                fb2=sum;
        }
            return sum;
    }

    //用HashMap来保存已经计算过的状态
    static Map<Integer,Integer> map=new HashMap();
    public static int solve3(int m){
        if(m<=2)
        {
            return m;
        }else {
            if(map.containsKey(m)){ //判断是否计算过
                return map.get(m);
            }else {
                int num=solve3(m-1)+solve3(m-2);
                map.put(m,num);
                return m;
            }

        }

    }
}
