package com.njupt.liner_table;

/**
 * 带表头结点的单链表
 */
public class HeaderList<T> {
    private Node<T> first;
    private Node<T> tail;
    private int nodeCount;

    HeaderList(){
        this.first = new Node<T>();
        this.tail = this.first;
        this.nodeCount = 0;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        return this.first == this.tail;
    }

    /**
     * 头插法
     * 带表头结点的单链表
     * @param x
     */
    public void insertHeader(T x){
        Node<T> node = new Node<>(x, null);
        node.setNext(this.first.getNext());
        this.first.setNext(node);
        this.nodeCount++;
        if(this.nodeCount == 1) this.tail = node;
    }

    /**
     * 尾插法
     * 代表头节点的单链表
     * @param x
     */
    public void insertTail(T x){
        Node<T> node = new Node<>(x, null);
        this.tail.setNext(node);
        this.tail = node;
        this.nodeCount++;
    }

    /**
     * 按位置删除单链表节点
     * 遍历到删除节点的前一个节点，接着断链
     * 注意点：当只有一个节点，且被删除时，要把尾指针tail修改等于头指针first
     * @param index
     */
    public void deleteByIndex(int index){
        if(this.nodeCount < index){
            System.out.println("索引越界");
            return;
        }
        Node node = this.first;
        //遍历到删除节点的前一个节点位置
        for(int i = 1; i < index; i++){
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        this.nodeCount--;
        if(this.nodeCount == 0) this.tail = this.first;
    }

    public void deleteByElement(T x){
        if(this.nodeCount == 0){
            System.out.println("空链表");
            return;
        }
        Node p = this.first;
        Node q = p.getNext();
        while(q != null){
            if(q.getData() == x)    break;
            p = p.getNext();
            q = q.getNext();
        }
        if (q == null) {
            System.out.println("没有找到该元素");
            return;
        }
        p.setNext(q.getNext());
    }

    /**
     * 返回实际元素的个数
     * @return
     */
    public int listSize(){
        return this.nodeCount;
    }

    /**
     * 遍历输出所有的节点
     */
    public void showAll(){
        Node p = this.first;
        while(p.getNext()!=null){
             p = p.getNext();
            System.out.println(p.getData());
        }
    }

    public static void main(String[] args) {
        HeaderList<Integer> list = new HeaderList<>();
        list.insertHeader(5);
        list.insertHeader(4);
        list.insertTail(10);
        list.insertTail(11);
        list.showAll();
        System.out.println("初始化元素个数："+list.listSize());
        list.deleteByIndex(1);
        System.out.println("删除了1号节点之后元素个数：" + list.listSize());
        list.showAll();
        System.out.println("______________________________________");
        System.out.println("_____________删除指定元素_______________");
        list.deleteByElement(4);
        System.out.println("删除了指定节点之后元素个数：" +list.listSize());
        list.showAll();
    }


}

