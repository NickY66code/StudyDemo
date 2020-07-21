package Demo.NodeQues;

import java.util.Scanner;

public class LinkedLists {
    int length =0; //链表长度
    Node head=new Node(0);//哨兵节点

    //头插法
    public void headInsert(int val){
        //1.构造一个新节点
        Node newNode= new Node(val);
        //2.插入到头结点之后的节点
        newNode.next=head.next;
        //3.将头结点的指向新节点
        head.next=newNode;
    }

    //尾插法
    public void lastInsert(int val){
        Node tmp =head;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=new Node(val);
    }

    //删除指定节点
    public void removeNode(Node deleteNode){

        //当删除结点是尾结点时，需要从头遍历，再把尾结点删掉
        if (deleteNode.next==null){
            Node tmp=head;
            while(tmp.next!=deleteNode){
                tmp=tmp.next;
            }
            //找到尾结点的前结点，然后删除
            tmp.next=null;
        }else {
            //删除结点在中间的时候
            Node nextNode=deleteNode.next;
            //把删除结点的后继结点的值赋给被删除结点
            deleteNode.data=nextNode.data;

            //将nextNode删掉
            deleteNode.next=nextNode.next;
            nextNode.next=null;
        }
    }


    //递归翻转
    public Node reverseList(Node head){
        //1.递归结束条件
        if(head==null||head.next==null){
            return head;
        }

        //2.递归反转子链表
        Node nextNode=reverseList(head.next);

        //改变1,2结点的指向
        //通过head.next获取结点
        Node newNode=head.next;
        //让2的next指向2
        newNode.next=head;
        //1的next指向null
        head.next=null;
        return nextNode;
    }

    //迭代翻转
    public void iterationInvertLinkedList(){
        //步骤一
        Node pre =head;
        Node cur =pre.getNext();

        pre.setNext(null); //pre是头结点，避免反转链表后形成环

        //步骤二
        while(cur!=null){
            Node next =cur.getNext();
            cur.setNext(pre);
            pre =cur;
            cur=next;
        }

        //此时pre指向的是原链表的尾结点，翻转后即为链表 head的后继结点
        head.next=pre;
    }

    public  void printList(){
        Node curNode =head;
        while(curNode!=null){
            System.out.print(curNode.data+"->");
            curNode=curNode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        LinkedLists linkedLists =new LinkedLists();
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入一段数组并以空格隔开");

        String str =sc.nextLine();
        String[] a =str.split(" ");
        int[] arr =new int[a.length];

        for (int i=0;i<a.length;i++){
            arr[i] =Integer.parseInt(a[i]);
        }

        Scanner sc1 =new Scanner(System.in);
        System.out.println("请输入翻转的终点");
        int point =sc1.nextInt();

        for (int j=0;j<=point;j++) {
            linkedLists.headInsert(arr[j]);

        }
        for (int k=point+1;k<arr.length;k++){
            linkedLists.lastInsert(arr[k]);
        }

        //linkedList.printList();

        //linkedList.reverseList(head);

        linkedLists.printList();
    }
}
