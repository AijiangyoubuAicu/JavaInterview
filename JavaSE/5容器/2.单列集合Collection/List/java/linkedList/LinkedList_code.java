package linkedList;

import java.io.Serializable;
import java.util.*;

public class LinkedList_code<E> extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, Serializable {

    // 基本实现逻辑代码

    /**
     * 记录长度的属性值
     */
    transient int size = 0;

    /**
     * 指向第一个节点的指针
     */
    transient Node<E> first;

    /**
     * 指向最后一个节点的指针
     */
    transient Node<E> last;

    /**
     * LinkedList 的内部私有类 Node
     *
     * 作为链表中的每一个节点，该类代表着双端链表的基本数值：节点值、前驱节点、后继节点
     *
     * @param <E>
     */
    private static class Node<E> {
        // 节点值
        E item;
        // 后继节点
        Node<E> next;
        // 前驱节点
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
//            this.next = next;
//            this.prev = prev;
        }
    }

    // 构造方法

    /**
     * 空参构造方法
     */
    public LinkedList_code() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * 用已有的集合创建链表的构造方法
     *
     * @param c 集合名
     */
    public LinkedList_code(Collection<? extends E> c) {
        this();
        addAll(c);
    }


    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public boolean add(E e) {
//        linkLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }
}
