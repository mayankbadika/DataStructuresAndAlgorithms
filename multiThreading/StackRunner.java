package myclass.multiThreading;

public class StackRunner {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter =0;
            while (++counter < 10) {
                System.out.println("Element pushed state :"+ stack.push(50));
            }
        },"Pusher").start();

        new Thread(() -> {
            int counter =0;
            while (++counter < 10) {
                System.out.println("Element poped = "+stack.pop());
            }
        },"Popper").start();
    }
}
