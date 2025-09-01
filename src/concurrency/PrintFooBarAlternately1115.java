package concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PrintFooBarAlternately1115 {

     private int n;
// Initial collection
        public final static List<Integer> initialCollection = Arrays.asList(1);

        public final static  int capacity = 1; // Set the capacity of the queue
       static  BlockingQueue<Integer> fooblockingQueue = new ArrayBlockingQueue<>(capacity, false, initialCollection);
       static  BlockingQueue<Integer> barblockingQueue = new ArrayBlockingQueue<>(capacity);


    public PrintFooBarAlternately1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            fooblockingQueue.poll(100,TimeUnit.MILLISECONDS);
        	printFoo.run();
            barblockingQueue.put(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            barblockingQueue.poll(100,TimeUnit.MILLISECONDS);
        	printBar.run();
            fooblockingQueue.put(1);
        }
    }

}
