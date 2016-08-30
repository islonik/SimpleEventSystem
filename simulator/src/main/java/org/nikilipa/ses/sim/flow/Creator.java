package org.nikilipa.ses.sim.flow;

import org.nikilipa.ses.sim.db.FinanceDao;
import org.nikilipa.ses.events.Priority;
import org.nikilipa.ses.sim.model.Task;
import org.nikilipa.ses.sim.services.EventNotifierWrapper;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikilipa on 7/23/16.
 */
public class Creator implements Runnable {

    private static final AtomicInteger counter = new AtomicInteger();

    private final PriorityQueue<Task> priorityQueue;

    public Creator(PriorityQueue<Task> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {

                int priority = ThreadLocalRandom.current().nextInt(0, 4);
                int code = ThreadLocalRandom.current().nextInt(0, 2);
                String financeCode = null;
                switch (code) {
                    case 0:
                        financeCode = FinanceDao.FINANCE_CODE_GENERAL;
                        break;
                    case 1:
                        financeCode = FinanceDao.FINANCE_CODE_SUPPORT;
                        break;
                    case 2:
                        financeCode = FinanceDao.FINANCE_CODE_MIGRATION;
                        break;
                    default:
                        financeCode = "Unknown finance code";
                }
                int estimate = ThreadLocalRandom.current().nextInt(2, 40);

                Task task = new Task(Priority.valueOf(priority), counter.get(), String.format("Task #%s", counter.getAndIncrement()), financeCode, estimate);

                EventNotifierWrapper.createdEvent(task);

                System.out.println(String.format("Task %s with priority %s was created", task.getTitle(), task.getPriority()));
                priorityQueue.add(task);

                long sleep = Long.valueOf(ThreadLocalRandom.current().nextInt(6000, 8000));
                System.out.println(String.format("The creator thread decided to sleep '%s' millisec", sleep));

                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
