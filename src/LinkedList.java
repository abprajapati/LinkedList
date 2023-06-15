public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next= null;
        }
    }
    public static Node head = null;
    public static Node tail= null;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
          head= tail= newNode;
          size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            tail=head=newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public void printLl(){
        if(head==null){
            System.out.println("Linked List is empty, no element found");
            return;
        }
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("NULL");
        System.out.println();

    }
    public void addMiddle(int data, int index){
        Node newNode= new Node(data);
        if(index==0){
            addFirst(data);
            return;
        }
        Node temp = head;

        for(int i =0 ; i < index-1; i++){
            temp = temp.next;
            if(temp==null){
                System.out.println("Index that you provided is out of bound");
                return;
            }
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;


    }
    public static int removeFirst(){
        int value;
        if(head==null){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            value = head.data;
            head=tail=null;
            size=0;
            return value;
        }
        value = head.data;
        head = head.next;
        size--;
        return value;
    }
    public static int removeLast(){
        if(head==null){
            System.out.println("Linked List is empty");
        }
        if(size==1){
            int value = head.data;
            head=tail=null;
            size=0;
            return value;
        }

        Node prev = head;
        int i=0;
        while(i < size-2){
            prev = prev.next;
            i++;
        }
        int value = prev.data;
        prev.next = null;
        tail=prev;
        size--;
        return value;
    }

    public void reverseLl(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNFromLast(int n)
    {
        Node temp = head;
        int size = 0;
        while(temp!= null){
            temp = temp.next;
            size++;
        }
        if(size == n ){
            head = head.next;
            return;
        }
        int index = size - n;
        int i = 1;
        Node prev = head;
        while( i < index){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return;
    }
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.printLl();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.printLl();
        ll.addMiddle(10,10 );
        ll.printLl();
        ll.removeFirst();
        ll.printLl();
        ll.removeLast();
        ll.printLl();
        ll.reverseLl();
        ll.printLl();
        ll.deleteNFromLast(2);
        ll.printLl();
        System.out.println(ll.size);
    }

}
