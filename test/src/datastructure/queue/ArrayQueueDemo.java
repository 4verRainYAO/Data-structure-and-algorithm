package datastructure.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("队列头数据:"+arrayQueue.peek());
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("====================");

        arrayQueue.add(2);
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("队列头数据:"+arrayQueue.peek());
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("====================");

        arrayQueue.add(3);
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("队列头数据:"+arrayQueue.peek());
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("====================");

        arrayQueue.add(4);
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println(arrayQueue.get());
        arrayQueue.show();
        System.out.println("rear:"+arrayQueue.getRear()+"=====front:"+arrayQueue.getFront());
        System.out.println("====================");
    }
}
class ArrayQueue{
    private int maxSize; //数组最大容量
    private int rear;//队列尾
    private int front;//队列头
    private int[] arr;//存数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        rear=-1;//指向队列的尾部，队列的最后一个数据
        front=-1;//指向队列的头部的前一个位置
        arr = new int[maxSize];
    }
    /**
     * 队列是否满了
     */
    public boolean isFull(){
        if(rear==maxSize-1){
            return true;
        }
        return false;
    }
    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        if(rear==front){
            return true;
        }
        return false;
    }
    /**
     * 队列添加元素
     */
    public void add(int n){
        if(isFull()){
            return;
        }
        //rear后移
        rear++;
        //添加
        arr[rear] = n;
    }
    /**
     * 队列取元素
     */
    public int get(){
        if(isEmpty()){
            return -1;
        }
        front++;
        return arr[front];
    }
    /**
     * 显示队列的所有数据
     */
    public void show(){
        if(isEmpty()){
            System.out.println("队列空");
        }
        for(int i=0;i<arr.length;i++){
            System.out.println("第"+i+"元素是"+arr[i]);
        }
    }
    /**
     * 显示头数据，不取出
     */
    public int peek(){
        //判断
        if(isEmpty()){
            return -1;
        }
        return arr[front+1];
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