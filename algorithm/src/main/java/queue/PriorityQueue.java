package queue;

public class PriorityQueue <E extends Comparable> {

    private Heap<E> heap=new Heap<E>();//用堆实现优先队列

    //入队列
    public void enqueue(E e){
        heap.add(e); //这个add以后，堆会自己调整成一个新堆
    }

    //出队列
    public E dequeue(){
        return heap.remove();//这移除出之后，堆会自己调整，还是一个新堆
    }

    public int getSize(){
        return heap.getSize();
    }

}
