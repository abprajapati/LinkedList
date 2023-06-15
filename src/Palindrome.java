public class Palindrome {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            size = 1;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        Node mid = findMid();
        if(head == null && head.next == null){
            return true;
        }
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        while(right!= null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

      return true;
    }

    public static void main(String[] args){
        Palindrome pal = new Palindrome();
        pal.addFirst(1);
        pal.addFirst(2);
        pal.addFirst(3);
        pal.addFirst(2);
        pal.addFirst(1);
        System.out.println(Palindrome.size);
        boolean check = pal.isPalindrome();
        if(check == true){
            System.out.println("Yes, palindrome");
        }
    }

}
