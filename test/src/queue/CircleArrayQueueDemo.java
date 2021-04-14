package queue;

/**
 * 环形队列实现
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.show();
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("====================");

        arrayQueue.add(2);
        arrayQueue.show();
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("====================");

        arrayQueue.add(3);
        arrayQueue.show();
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("====================");

        arrayQueue.add(4);
        arrayQueue.show();
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("====================");

        arrayQueue.add(5);
        arrayQueue.show();
    }
}
class CircleArrayQueue{
    private int maxSize;
    //rear执行队列的最后一个元素的后一个位置，arr[rear-1]是队列的最后一个元素，rear初始值==0
    private int rear;
    //front指向队列的第一个元素，arr[front]是队列的第一个元素，front初始值==0
    private int front;

    private int[] arr;

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        if((rear+1)%maxSize==front){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(rear==front){
            return true;
        }
        return false;
    }
    public void add(int n){
        if(isFull()){
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，取模
        rear = (rear+1)%maxSize;
    }
    public int get(){
        if(isEmpty()){
            return -1;
        }
        //front是指向队列的第一个元素
        //1.front 对应的值保留到临时变量
        int value = arr[front];
        //2.front 后移 取模
        front = (front+1)%maxSize;
        //3.临时变量返回
        return value;
    }
    public void show(){
        if(isEmpty()){
            System.out.println("队列空");
        }

        for(int i=0;i<front+size();i++){
            System.out.println("第"+i%maxSize+"元素是"+arr[i%maxSize]);
        }
    }

    /**
     * 求出当前队列的有效数据个数
     * @return
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 显示头元素
     * @return
     */
    public int head(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
