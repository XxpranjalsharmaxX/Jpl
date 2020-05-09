import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 class Jpl6
{
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        Thread p1 = new Thread(p);
        Thread p2 = new Thread(p);
        p1.start();
        p2.start();
        Thread c1 = new Thread(c);
        Thread c2 = new Thread(c);
        c1.start();
        c2.start();
    }
}
class MyBlockingQueue
{
    private static final int CAPACITY = 10;
    private final Queue queue = new LinkedList<>();
    private final Random theRandom = new Random();

//    lock and condition variables
    private final Lock lock = new ReentrantLock();
    private final Condition notfull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


//    to put into the queue
    public void put() throws InterruptedException
    {
        lock.lock();
        try {
            while (queue.size()==CAPACITY)
            {
                System.out.println(Thread.currentThread().getName()+
                        ": queue is full , waiting");
                notEmpty.await();
            }
            int number = (int) (Math.random()*1000);
            boolean isAdded = queue.offer(number);
            if (isAdded) {
                System.out.println(Thread.currentThread().getName()+" added "+ number+" to the queue");

                System.out.println(Thread.currentThread().getName()+": queue is not empty now");
                notfull.signalAll();
            }
        }
        finally {
            lock.unlock();
        }

    }
    public void take() throws InterruptedException
    {
        lock.lock();
        try {

            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + ": queue is empty,waiting");
                notfull.await();
            }
            Integer value = (Integer) queue.poll();
            if (value != null) {
                System.out.println(Thread.currentThread().getName() + " removed " + value + " from the queue");
                System.out.println(Thread.currentThread().getName() +
                        ": queue has capacity now");
                notEmpty.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }
}
class Producer extends Thread
{
    MyBlockingQueue queue;

    public Producer(MyBlockingQueue queue) {
        super("PRODUCER");
        this.queue = queue;
    }

    @Override
    public void run() {
    try {
        queue.put();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
class Consumer extends Thread
{
    MyBlockingQueue queue;

    public Consumer(MyBlockingQueue queue) {
        super("PRODUCER");
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
