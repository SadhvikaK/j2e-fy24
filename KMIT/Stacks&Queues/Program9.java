import java.util.*;
public class Program9{
    private Stack<int[]> stack;

    public Program9() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, span});
        return span;
    }
    public static void main(String[] args) {
        Program9 stockSpanner = new Program9();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}