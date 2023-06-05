import java.util.*;

class ListNode3
{
    int data;
    ListNode3 next;
    ListNode3(int x) {
        data = x;
    }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Program4 p = new Program4();
        String list[] = sc.nextLine().split(" ");
        for(int i=0; i<list.length; i++)
        {
            p.addNode(Integer.parseInt(list[i]));
        }
        ListNode3 curr = p.deleteDups(p.head);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        sc.close();
    }
    public ListNode3 head = null;
    public ListNode3 temp = null;
    public void addNode(int data)
    {
        ListNode3 newNode = new ListNode3(data);
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
    public ListNode3 deleteDups(ListNode3 head) {
        ListNode3 curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}