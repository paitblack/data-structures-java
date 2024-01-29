import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }
    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head;
        head=newNode;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        Node<T> iterator=head;
        while(iterator.next!=null)
            iterator=iterator.next;
        iterator.next=newNode;

    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;
        }
    }
    public  boolean search(T val){
        Node<T> newNode = createNode(val);
        Node<T> first = head;
        while (first != null){
            if(first.value == newNode.value) {
                return true;
            }
            first = first.next;
        }
        return false;
    }
    public int count(){
        Node<T> first = head;
        int count = 0;
        while (first != null){
            count++;
            first = first.next;
        }
        return count;
    }
    /*public void FindMin(){
        ArrayList<Integer> list = new ArrayList<>();
        Node<T> first = head;
        if(head == null){
            System.out.println("Empty List !");
        }
        while(first != null){
            list.add(Integer.parseInt(first.value.toString()));
            first = first.next;
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
     */
    /*public void sortedInsert(T val) {
        Node<T> newNode = createNode(val);

        if (head == null || Integer.parseInt(newNode.value.toString()) < Integer.parseInt(head.value.toString())) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> first = head;
            while (first.next != null && Integer.parseInt(newNode.value.toString()) > Integer.parseInt(first.next.value.toString())) {
                first = first.next;
            }
            newNode.next = first.next;
            first.next = newNode;
        }
    }
     */
    public T findMin(){
        if(head == null)
            return null;
        T min = head.value;
        Node<T> iterator = head.next;
        while(iterator != null){
            if(min.compareTo(iterator.value)==1)
                min = iterator.value;
            iterator=iterator.next;
        }
        return  min;
    }
    public void sortedInsert(T val){
        Node<T> newNode = createNode(val);
        if(head == null)
            head = newNode;
        else if (val.compareTo(head.value)<=0) {
            newNode.next = head;
            head = newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next != null && iterator.next.value.compareTo(val)==-1) {
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }

    }
    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0)
            head=head.next;
        else{
            Node<T> previous=head , iterator = head;
            while(iterator!=null && iterator.value.compareTo(val)!=0){
                previous=iterator;
                iterator=iterator.next;
            }
            if(iterator!= null)
                previous.next=iterator.next;
        }
    }
    public Node<T> recursiveAddToEnd(Node<T> tempHead,T val){
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next,val);

        }
        return tempHead;
    }
    public void recursiveAddToEnd(T val){
        head=recursiveAddToEnd(head,val);
    }

    public void deleteTheSame(T val) {
        if (head == null) {
            return;
        }

        while (head != null && head.value.compareTo(val) == 0) {
            head = head.next; // Skip all nodes at the beginning with the value to delete
        }

        Node<T> previous = head;
        Node<T> iterator = head;

        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0) {
                previous.next = iterator.next;
            } else {
                previous = iterator;
            }
            iterator = iterator.next;
        }
    }
    public Node<T> recursiveSearch(T val) {
        return recursiveSearch(head, val);
    }
    private Node<T> recursiveSearch(Node<T> tempHead, T val) {
        if (tempHead == null) {
            System.out.println("Value not found");
            return null;
        }
        if (tempHead.value.compareTo(val) == 0) {
            System.out.println("Value found");
            return tempHead;
        }
        return recursiveSearch(tempHead.next, val);
    }
    public void swapFirstLast() {
        if (head == null || head.next == null) {
            return;
        }
        Node<T> previous = head;
        Node<T> iterator = head;

        while (iterator.next != null) {
            previous = iterator;
            iterator = iterator.next;
        }
        if(head.next == iterator){
            iterator.next = head;
            head.next = null;
            head = iterator;
        }else{
            iterator.next = head.next;
            previous.next = head;
            head.next = null;
            head = iterator;
        }
    }
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            Node<T> left = head;
            Node<T> right = null;

            while (left.next != right) {
                if (left.value.compareTo(left.next.value) > 0) {
                    T temp = left.value;
                    left.value = left.next.value;
                    left.next.value = temp;
                    swapped = true;
                }
                left = left.next;
            }
        }
    }
    public void selectionSort(LinkedList<T> llist) {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> iterator = head;
        while (iterator != null) {
            Node<T> minNode = llist.findMinNode(iterator);
            T iterValue = iterator.value;
            iterator.value = minNode.value;
            minNode.value = iterValue;
            iterator = iterator.next;
        }
    }
    public Node<T> findMinNode(Node<T> current) {
        Node<T> min = current;
        Node<T> iterator = current;

        while (iterator != null) {
            if (iterator.value.compareTo(min.value) < 0) {
                min = iterator;
            }
            iterator = iterator.next;
        }

        return min;
    }
}
