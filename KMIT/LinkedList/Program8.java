import java.util.*;
public class Program8{
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Program8 insert(Program8 list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(Program8 list) {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void mergeBetween(Program8 list1, int a, int b, Program8 list2) {
        if (list1 == null) {
            printList(list2);
            return;
        }
        Node temp = list1.head;
        Node p = null;
        int count = 0;
        while (count < a) {
            p = temp;
            temp = temp.next;
            count++;
        }
        if (a == 0) {
            while (count <= b) {
                temp = temp.next;
                count++;
            }
            Node t = list2.head;
            while (t.next != null) t = t.next;
            t.next = temp;
            list1.head = list2.head;
            printList(list1);
            return;
        }
        Node d = p;
        Node t = list2.head;
        while (t.next != null) t = t.next;
        d.next = list2.head;
        while (count < b) {
            temp = temp.next;
            count++;
        }
        t.next = temp.next;
        printList(list1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Program8 list = new Program8();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list = insert(list, x);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        Program8 list1 = new Program8();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            list1 = insert(list1, x);
        }
        mergeBetween(list, a, b, list1);

    }
}