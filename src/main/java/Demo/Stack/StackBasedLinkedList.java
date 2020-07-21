package Demo.Stack;



public class StackBasedLinkedList {
    class Node{
        int data;
        Node next =null;

        public Node(int data){
            this.data=data;
        }

    }
    //定义栈顶指针
    Node head =new Node(0);
    /*
    入栈
     */
    public void push(int val){
        Node tmp=new Node(val);

        tmp.next=head;

        head=tmp;
    }
  /*
  出栈
   */
  public int pop(){

      //执行出栈操作，将栈顶元素赋值给value
      int value =head.data;

      //删除head结点，指针下移
      head=head.next;

      return value;
  }

  public void printAll(){
      Node tmp=head;
      while(tmp!=null){
          System.out.print(tmp.data+" ");
          tmp=tmp.next;
      }
      System.out.println();

  }
}
