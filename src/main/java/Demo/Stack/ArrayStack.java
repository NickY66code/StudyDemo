package Demo.Stack;

public class ArrayStack {
    public String[] items; //栈数组
    public int count;     //栈中的个数
    public int n;         //栈大小

    public ArrayStack(int n){
        this.items=new String[n];
        this.count=0;
        this.n=n;
    }

    /***
     * 入栈
     * @param val
     * @return 返回入栈是否成功
     */
    public boolean push(String val){
        if (count==n){
            return false;
        }
        items[count] =val;
        ++count;
        return true;
    }

    /**
     * 出栈
     * @param val
     * @return 返回栈的值
     */
    public String pop(String val){
        if (count==0){
            return null;
        }

        String tmp=items[count];
        --count;
        return tmp;
    }

}
