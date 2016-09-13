package org.nikilipa.ses.sim.flow;

import org.nikilipa.ses.sim.model.Task;
import org.nikilipa.ses.sim.services.EventNotifierWrapper;
import org.nikilipa.ses.sim.services.FinanceService;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nikilipa on 7/23/16.
 */
public class Validator implements Runnable {

    private final FinanceService financeService;
    private final PriorityBlockingQueue<Task> fromCreator;
    private final PriorityBlockingQueue<Task> toWorker;

    public Validator(FinanceService financeService, PriorityBlockingQueue<Task> fromCreator, PriorityBlockingQueue<Task> toWorker) {
        this.financeService = financeService;
        this.fromCreator = fromCreator;
        this.toWorker = toWorker;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = fromCreator.poll();
                if (task != null) {
                    if (financeService.isEnoughMoney(task.getFinanceCode(), task.getEstimate())) {
                        System.out.println(String.format("The task '%s' with priority '%s' was accepted", task.getTitle(), task.getPriority()));
                        financeService.updateFinance(task.getFinanceCode(), task.getEstimate());

                        EventNotifierWrapper.acceptedEvent(task);
                        toWorker.add(task);
                    } else {
                        EventNotifierWrapper.rejectedEvent(task);
                        System.out.println(String.format("The task '%s' with priority '%s' was rejected", task.getTitle(), task.getPriority()));
                    }
                }

                long sleep = Long.valueOf(ThreadLocalRandom.current().nextInt(6000, 10000));
                System.out.println(String.format("The validator thread decided to sleep %s millisec", sleep));
                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
