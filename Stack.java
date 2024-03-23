public class Stack {
    private int [] values;
    private int top;
    public Stack(int size){
        this.top=-1;
        this.values=new int[size];
    }
    public int size(){
        return values.length;
    }
    public int peek(){
        if (isEmpty())
            return -1;
        return this.values[this.top];
    }
    public int count(){
        return this.top+1;
    }
    public boolean isEmpty(){
        //if(this.top==-1)
        //   return true;
        //else return false;
        return this.top==-1;
    }
    public boolean isFull(){
        return this.top==values.length-1;
    }
    public void push(int val){
        if(isFull()){
            System.out.println("stack is full");
        }else{
            this.top++;
            this.values[top]=val;
        }
    }
    public int pop(){
        if (isEmpty())
            return -1;
        this.top--;
        return values[this.top+1];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        for (int i = this.top; i>-1 ; i--) {
            System.out.println(this.values[i]);
        }

    }
}