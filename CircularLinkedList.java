public class CircularLinkedList<T extends Comparable> {
    Node<T> head;
    public void insertToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
        }
    }
    public void insertToFront(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public void display(){
        Node<T> iterator = head;
        while(iterator.next != head && head != null){
            System.out.println(iterator);
            iterator=iterator.next;
        }
        System.out.println(iterator);
    }
    public void delete(T val){
        if(head == null)
            return;
        if (head.value.compareTo(val)==0){
            head = head.next;
        }else{
            Node<T> previous = head , iterator = head;
            while(iterator != null && iterator.value.compareTo(val) != 0){
                previous = iterator;
                iterator = iterator.next;
            }
            if(iterator != null)
                previous.next = iterator.next;
        }
    }
}