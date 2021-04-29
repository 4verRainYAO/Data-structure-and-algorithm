package datastructure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        doubleLinkedList.addNodeOnTail(node1);
        doubleLinkedList.addNodeOnTail(node2);
        doubleLinkedList.addNodeOnTail(node3);
        doubleLinkedList.addNodeOnTail(node4);
        System.out.println("从前往后遍历");
        doubleLinkedList.listFrontToBack();
    }
}
class DoubleLinkedList{
    //初始化头结点
    private DoubleNode head = new DoubleNode(0);

    public DoubleNode getHead() {
        return head;
    }

    /**
     * 遍历双向链表，从前往后
     */
    public void listFrontToBack(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        while(true){
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
    }
    /**
     * 遍历从后往前
     */
    public void listBackToFront(){

    }

    /**
     * 添加节点，尾插法
     */
    public void addNodeOnTail(DoubleNode doubleNode){
        if(head.next==null){
            head.next = doubleNode;
            return;
        }
        DoubleNode temp = head.next;
        while(true){
            if(temp.next==null){
                //说明当前节点就是最后一个了
                break;
            }
            temp = temp.next;
        }
        temp.next = doubleNode;
        doubleNode.pre = temp;
        doubleNode.next = head;
    }

    public void addNodeOnHead(DoubleNode doubleNode){
        if(head.next==null){
            head.next = doubleNode;
            return;
        }
        DoubleNode temp = head.next;
        head.next = doubleNode;
        doubleNode.pre = head;
        temp.pre = doubleNode;
        doubleNode.next = temp;
    }

}
//创建双向链表类
class DoubleNode{
    private int val;
    public DoubleNode pre; //指向前一个节点，默认null
    public DoubleNode next;//指向后一个节点，默认null

    public DoubleNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "val=" + val +
                '}';
    }
}
