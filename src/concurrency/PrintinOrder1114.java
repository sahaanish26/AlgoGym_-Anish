package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class PrintinOrder1114 {

    //Creating BlockingQueue of size 1
       // BlockingQueue<String> fQueue = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> sQueue = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> tQueue = new ArrayBlockingQueue<>(1);
     

    public PrintinOrder1114() {
       
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        sQueue.put("Second");
       
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        sQueue.poll(10, TimeUnit.SECONDS);
        printSecond.run();
        tQueue.put("third");

       
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
       

        tQueue.poll(10, TimeUnit.SECONDS);
       printThird.run();

       
    }

}
