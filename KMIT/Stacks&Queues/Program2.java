import java.util.*;
class Queue1{
    Stack <Integer> s1 = new Stack<>();
    Stack <Integer> s2 = new Stack<>();

    void enqueue(int x){
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        s2.push(x);
        while(!s1.empty()){
            s2.push(s1.pop());
        }
    }
    int dequeue(){
        if(s2.empty())  return -1;
        return s2.pop();
    }
}
public class Program2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue1 obj = new Queue1();
        while(n>0){
            int q = sc.nextInt();
            if(q==1){
                int x = sc.nextInt();
                obj.enqueue(x);
                n--;
            }
            else if(q==2){
                System.out.print(obj.dequeue()+" ");
            }
        }
    }
}