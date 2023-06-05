import java.util.LinkedList;
import java.util.Queue;

class Stack1{
    Queue <Integer> q1 = new LinkedList<>();
    Queue <Integer> q2 = new LinkedList<>();
    void push(int x){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
    int pop(){
        if(q1.isEmpty())    return -1;
        return q1.remove();
    }
}
public class Program1{
    public static void main(String[] args) {
        Stack1 stk = new Stack1();
        stk.push(2);
        stk.push(3);
        System.out.print(stk.pop()+" ");
        stk.push(4);
        System.out.print(stk.pop()+" ");
    }
}