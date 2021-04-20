package linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1,"a","A");
        Node node2 = new Node(2,"b","B");
        Node node3 = new Node(3,"c","C");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node3);
//        singleLinkedList.addByOrder(node3);
//        singleLinkedList.addByOrder(node2);
//        singleLinkedList.addByOrder(node1);
        singleLinkedList.list();
        System.out.println("===============");
        //测试修改节点的代码
//        Node node4 = new Node(2,"dsada","DSADDSA");
//        singleLinkedList.update(node4);
//        singleLinkedList.list();
        //删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
        singleLinkedList.list();
    }
}

class SingleLinkedList{
    //初始化头结点，头结点不动,不存放具体数据
    private Node head = new Node(0,"","");

    /**
     * 添加节点到单项链表，添加到最末尾
     * 思路，当不考虑编号的顺序时
     * 1.找到当前链表的最后一个节点
     * 2.最后一个节点的next指向node
     */
    public void addNode(Node node){
        //head节点不能动，需要一个辅助节点
        Node temp = head;
        //遍历链表
        while (true){

            //找到链表的最后
            if(temp.next==null){
                break;
            }else{
                //没找到，后移一个
                temp = temp.next;
            }
        }
        //退出while循环，temp指向最后
        temp.next = node ;
    }

    /**
     * 链表的插入,按照Node.no的大小插入节点
     */
    public void addByOrder(Node node){
        //单链表要找到添加位置的前一个节点
        Node temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no>node.no){
                //则说明找到了插入的位置
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    /**
     * 根据编号,修改节点的信息
     */
    public void update(Node node){
        //链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        Node temp = head;

        boolean flag = false;//是否找到了要修改的节点
        while(true){
            if(temp.next==null){
                //到了链表的末尾
                break;
            }
            temp = temp.next;
            if(temp.no == node.no){
                //找到了
                flag = true;
            }
        }
        if(flag){
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else{
            //没找到该编号的节点
            System.out.println("没有找到编号是:"+node.no+"的节点");
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no){
        Node temp = head;
        boolean flag = false;//是否找到待删除节点的前一个节点
        while (true){
            if(temp.next==null){
                //链表的末尾
                break;
            }
            if(temp.next.no == no){
                //找到删除的位置了，即temp节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //找到了 删除
            temp.next = temp.next.next;
        }else{
            System.out.println("要删除的该节点不存在");
        }
    }

    /**
     * 显示链表，遍历
     */
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //不为空，遍历
        Node temp = head.next;
        while(true){
//            System.out.println(temp);
//            if(temp.next==null){
//                break;
//            }
//            temp = temp.next;
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class Node{
    //编号
    public int no;
    //名称
    public String name;
    //别名
    public String nickName;
    //指向下一个节点
    public Node next;

    public Node(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
