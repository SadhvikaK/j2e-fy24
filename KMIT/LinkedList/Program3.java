import java.util.*;

class ListNode2
{
    int data;
    ListNode2 next;
    ListNode2(int x) {
        data = x;
    }
}
public class Program3{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Program3 p = new Program3();
        String list[] = sc.nextLine().split(" ");
        for(int i=0; i<list.length; i++)
        {
            p.addNode(Integer.parseInt(list[i]));
        }
        ListNode2 curr = p.swapPairs(p.head);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        sc.close();
    }
    public ListNode2 head = null;
    public ListNode2 temp = null;
    public void addNode(int data)
    {
        ListNode2 newNode = new ListNode2(data);
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
    public ListNode2 swapPairs(ListNode2 head) {
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 prev = dummy;
        ListNode2 curr = head;
        while (curr != null && curr.next != null) {
            ListNode2 next = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = next;
            prev = curr;
            curr = next;
        }
        return dummy.next;
    }
}