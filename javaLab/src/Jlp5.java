public class Jlp5 {
    public static void main(String[] args) {
       MyClass myClass = new MyClass();
       Thread t1 = new Thread(myClass);
       Thread t2 = new Thread(myClass);
       t1.setPriority(1);
       t2.setPriority(Thread.NORM_PRIORITY);
       t1.start();
       t2.start();
    }
}

class MyClass implements Runnable
{

    @Override
    public synchronized void run() {
        int count =0;
        for (int i = 0;i<1000;i++)
        {
            count++;
        }
        System.out.println("Completed thread:: " + Thread.currentThread().getName());
        System.out.println("Thread priority:: " + Thread.currentThread().getPriority());
    }
}