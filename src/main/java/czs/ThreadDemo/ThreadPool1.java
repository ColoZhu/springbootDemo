package czs.ThreadDemo;

import czs.alibabaeazyexcel.TestRead;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 有返回值的线程
 */

public class ThreadPool1 {
    public static void main(String[] args) {

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 1; i < taskSize + 1; i++) {
            Callable c = new MyCallable(i);
            // 执行任务并获取Future对象
            Future f = pool.submit(c);

            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
       /* for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }*/
    }
}

class MyCallable implements Callable<Object> {
    private int taskNum;

    MyCallable(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() {
        System.out.println(">>>" + taskNum + "任务启动");

        System.out.println("Eazyexcel任务执行中.......");
        TestRead testRead = new TestRead();
        testRead.exceptionRead(taskNum);

        System.out.println(">>>" + taskNum + "任务终止");
        return null;
    }
}