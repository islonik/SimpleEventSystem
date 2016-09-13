package org.nikilipa.ses.sim.services;

import org.nikilipa.ses.sim.model.Task;
import org.springframework.stereotype.Service;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by nikilipa on 8/25/16.
 */
@Service
public class QueueServices {

    private final PriorityBlockingQueue<Task> creationQueue = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<Task> validationQueue = new PriorityBlockingQueue<>();

    public PriorityBlockingQueue<Task> getValidationQueue() {
        return validationQueue;
    }

    public PriorityBlockingQueue<Task> getCreationQueue() {
        return creationQueue;
    }

}
