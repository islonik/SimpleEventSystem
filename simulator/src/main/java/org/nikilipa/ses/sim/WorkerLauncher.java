package org.nikilipa.ses.sim;

import org.nikilipa.ses.sim.flow.Creator;
import org.nikilipa.ses.sim.flow.Reporter;
import org.nikilipa.ses.sim.flow.Validator;
import org.nikilipa.ses.sim.flow.Worker;
import org.nikilipa.ses.sim.model.Task;
import org.nikilipa.ses.sim.services.FinanceService;
import org.nikilipa.ses.sim.services.QueueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nikilipa on 7/23/16.
 */
@Component
public class WorkerLauncher {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private QueueServices queueServices;

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private volatile PriorityQueue<Task> fromCreator;
    private volatile PriorityQueue<Task> fromValidator;

    @PostConstruct
    public void post() {
        fromCreator = queueServices.getCreationQueue();
        fromValidator = queueServices.getValidationQueue();
    }

    public void launch() {
        executorService.execute(new Creator(fromCreator));
        executorService.execute(new Validator(financeService, fromCreator, fromValidator));
        executorService.execute(new Worker(fromValidator));
        executorService.execute(new Reporter());
    }
}
