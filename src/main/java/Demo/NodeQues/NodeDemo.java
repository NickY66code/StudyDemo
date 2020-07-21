package Demo.NodeQues;

    public class NodeDemo {
        int length =0;//链表长度
        Node head=new Node(0); //哨兵节点
        public void addNode(int val){
            Node tmp=head;
            while(tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.next=new Node(val);
        }

    }
