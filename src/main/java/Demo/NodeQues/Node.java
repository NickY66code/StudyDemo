package Demo.NodeQues;

public class Node {
    int data;//节点的数值域,值
    Node next = null; //节点的引用，指向下一个节点

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }
}
