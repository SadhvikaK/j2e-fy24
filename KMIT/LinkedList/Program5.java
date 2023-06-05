import java.util.*;

class ListNode4
{
    int data;
    ListNode4 next;
    ListNode4(int x) {
        data = x;
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Program5 p = new Program5();
        String list[] = sc.nextLine().split(" ");
        for(int i=0; i<list.length; i++)
        {
            p.addNode(Integer.parseInt(list[i]));
        }
        ListNode4 curr = p.deleteDuplicates(p.head);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        sc.close();
    }

    public ListNode4 head = null;
    public ListNode4 temp = null;

    public void addNode(int data)
    {
        ListNode4 newNode = new ListNode4(data);
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

    public ListNode4 deleteDuplicates(ListNode4 head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode4 curr = head;
        while (curr != null) {
            if (map.containsKey(curr.data)) {
                map.put(curr.data, map.get(curr.data) + 1);
            } else {
                map.put(curr.data, 1);
            }
            curr = curr.next;
        }
        ListNode4 dummy = new ListNode4(0);
        ListNode4 tail = dummy;
        curr = head;
        while (curr != null) {
            if (map.get(curr.data) == 1) {
                tail.next = new ListNode4(curr.data);
                tail = tail.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}