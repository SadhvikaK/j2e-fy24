import java.util.*;
class ListNode1{
    int data;
    ListNode1 next;
    ListNode1(int x) {
        data = x;
    }
}
class Program1{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Program1 p = new Program1();
        String list[] = sc.nextLine().split(" ");
        for(int i=0; i<list.length; i++)
        {
            p.addNode(Integer.parseInt(list[i]));
        }
        int n = sc.nextInt();
        ListNode1 curr = p.removeNthFromEnd(p.head, n);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        sc.close();
    }
    public ListNode1 head = null;
    public ListNode1 temp = null;
    public void addNode(int data)
    {
        ListNode1 newNode = new ListNode1(data);
        if(head == null)
        {
            head = newNode;
            temp = newNode;
        }
        else
        {
            temp.next = newNode;
            temp = newNode;
        }
    }
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        ListNode1 p = head;
        ListNode1 q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        if (q == null) {
            return head.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}