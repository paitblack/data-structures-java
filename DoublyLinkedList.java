public class DoublyLinkedList <T extends Comparable>{
    DNode<T> head;
    public DNode<T> createNode(T val){
        return new DNode<>(val);
    }
    public void insertToFront(T val){
        DNode<T> newNode = createNode(val);
        if(head == null)
            head = newNode;
        else{
            newNode.next=head;
            head.prev = newNode;
            head=newNode;
        }
    }
    public void insertToEnd(T val){
        DNode<T> newNode = createNode(val);
        if(head == null)
            head = newNode;
        else{
            DNode<T> iterator = head;
            while (iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
        }
    }
    public void delete(T val){
        if(head == null)
            return;
        else if (head.value.compareTo(val)==0){
            head = head.next;
            if(head!=null)
                head.prev=null;
        }else{
            DNode<T> iterator = head;
            while (iterator!= null && iterator.value.compareTo(val)!= 0){
                iterator = iterator.next;
            }
            if(iterator == null)
                return;
            else{
                iterator.prev.next = iterator.next;
                if(iterator.next != null)
                    iterator.next.prev = iterator.prev;
            }
        }

    }
    public void display(){
        DNode<T> iterator = head;
        while (iterator != null){
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }
}
